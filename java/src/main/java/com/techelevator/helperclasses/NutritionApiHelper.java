package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.MealInformation;
import com.techelevator.model.pojos.glycemicloadapi.glcalculation.GlycemicLoadData;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.Ingredients;
import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;
import com.techelevator.model.pojos.nutritionapi.wrappers.TotalNutrients;
import com.techelevator.services.GLLookupService;
import com.techelevator.services.NutritionLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@Component
public class NutritionApiHelper {

    private static final Logger logger = LoggerFactory.getLogger(NutritionApiHelper.class);
    private final NutritionLookupService nutritionLookupService;
    private final GLLookupService glLookupService;
    private MealDao mealDao;

    public NutritionApiHelper(NutritionLookupService nutritionLookupService, GLLookupService glLookupService, MealDao mealDao) {
        this.nutritionLookupService = nutritionLookupService;
        this.glLookupService = glLookupService;
        this.mealDao = mealDao;
    }

    public void handleMealCreationAndNutritionData(String query, Meal meal, int userId) throws InterruptedException, ExecutionException, SQLException {
        long startTime = System.currentTimeMillis();
        logger.info("Start time for meal creation and nutrition data operation: " + startTime);

        CompletableFuture<NutritionInfo> nutritionInfo = handleNutritionalInformationCall(query, meal, userId);
        CompletableFuture<GlycemicLoadData> glLoadData = handleObtainingGlLoad(query);

        CompletableFuture.allOf(nutritionInfo, glLoadData).join();

        saveMealInformation(glLoadData.get().getTotalGlycemicLoad(), nutritionInfo.get().getTotalNutrients(), userId);

        logger.info("End time for meal creation and nutrition data operation: " + System.currentTimeMillis());
    }

    private CompletableFuture<NutritionInfo> handleNutritionalInformationCall(String query, Meal meal, int userId) throws InterruptedException, ExecutionException {
        return nutritionLookupService.findNutritionInfo(query).thenApply((returnValue) -> {
            Meal mealToInsert = createMealFromObject(query, meal, returnValue);
            try {
                mealDao.createNewMeal(userId, mealToInsert);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return returnValue;
        });
    }

    private Meal createMealFromObject(String query, Meal meal, NutritionInfo nutritionInfo) {
        int ONE_SERVING_CARBOHYDRATES = 15;
        meal.setServingSizeCarbs(nutritionInfo.getTotalDaily().getChocdf().getQuantity() / ONE_SERVING_CARBOHYDRATES);
        meal.setFoodName(query.substring(0, 1).toUpperCase() + query.substring(1).toLowerCase());
        if (meal.getTimeOfMeal() == null) {
            meal.setTimeOfMeal(LocalTime.now());
        }
        if (meal.getDateOfMeal() == null) {
            meal.setDateOfMeal(LocalDate.now());
        }
        return meal;
    }

    private CompletableFuture<GlycemicLoadData> handleObtainingGlLoad(String query) throws InterruptedException, ExecutionException {
        CompletableFuture<IngredientAnalysis> ingredientAnalysis = glLookupService.getQueryIngredients(query);
        return ingredientAnalysis.thenApply((returnValue) -> {
            try {
                CompletableFuture<GlycemicLoadData> result = glLookupService.getGlycemicLoadForQuery(query, Stream.of(returnValue.getIngredients()).map(Ingredients::getName).toArray(String[]::new));
                return result.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // This is an ineffecient part of the solution, but I currently cannot figure out a better way to extract the meal Id from the previous methods
    // without making a call here. Additionally, it isn't clean to simply call the setters on everything, but I cannot figure out a faster way to do it.
    private void saveMealInformation(double glycemicIndexCalculation, TotalNutrients totalNutrients, int userId) throws RuntimeException {

        try {
            MealInformation mealInformation = new MealInformation();
            mealInformation.setMealId(mealDao.getMostRecentUserMeal(userId).getMealId());
            mealInformation.setGlycemicLoad(glycemicIndexCalculation);
            setGenericAttributes(mealInformation, totalNutrients);
            mealDao.saveMealInformation(mealInformation.getMealId(), mealInformation);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private void setGenericAttributes(MealInformation mealInformation, TotalNutrients totalNutrients) {
        mealInformation.setCalories(totalNutrients.getEnerc_Kcal().getQuantity());
        mealInformation.setTotalFats(totalNutrients.getFat().getQuantity());
        mealInformation.setSaturatedFats(totalNutrients.getFasat().getQuantity());
        mealInformation.setTransFats(totalNutrients.getFatrn().getQuantity());
        mealInformation.setFattyAcidsMonosaturated(totalNutrients.getFams().getQuantity());
        mealInformation.setFatyAcidsPolyUnsaturated(totalNutrients.getFapu().getQuantity());
        mealInformation.setCarbsByDifference(totalNutrients.getChocdf().getQuantity());
        mealInformation.setTotalCarbs(totalNutrients.getChocdfNet().getQuantity());
        mealInformation.setFiber(totalNutrients.getFibtg().getQuantity());
        mealInformation.setSugars(totalNutrients.getSugar().getQuantity());
        mealInformation.setAddedSugars(totalNutrients.getAddedSugar().getQuantity());
        mealInformation.setCholesterol(totalNutrients.getChole().getQuantity());
        mealInformation.setSodium(totalNutrients.getNa().getQuantity());
        mealInformation.setCalcium(totalNutrients.getCa().getQuantity());
        mealInformation.setMagnesium(totalNutrients.getMg().getQuantity());
        mealInformation.setPotassium(totalNutrients.getK().getQuantity());
        mealInformation.setIron(totalNutrients.getFe().getQuantity());
        mealInformation.setZinc(totalNutrients.getZn().getQuantity());
        mealInformation.setPhosphorous(totalNutrients.getP().getQuantity());
        mealInformation.setVitaminA(totalNutrients.getVitaRae().getQuantity());
        mealInformation.setVitaminC(totalNutrients.getViTc().getQuantity());
        mealInformation.setThamin(totalNutrients.getThia().getQuantity());
        mealInformation.setRiboflavin(totalNutrients.getRibf().getQuantity());
        mealInformation.setNiacin(totalNutrients.getNia().getQuantity());
        mealInformation.setVitaminB6(totalNutrients.getVitb6A().getQuantity());
        mealInformation.setFolate(totalNutrients.getFoldfe().getQuantity());
        mealInformation.setFolateFromFood(totalNutrients.getFolfd().getQuantity());
        mealInformation.setFolicAcid(totalNutrients.getFolac().getQuantity());
        mealInformation.setVitB12(totalNutrients.getVitb12().getQuantity());
        mealInformation.setVitD(totalNutrients.getVitd().getQuantity());
        mealInformation.setVitE(totalNutrients.getTopcha().getQuantity());
        mealInformation.setVitK(totalNutrients.getK().getQuantity());
        mealInformation.setWater(totalNutrients.getWater().getQuantity());
    }

    public CompletableFuture<NutritionInfo> getNutritionInfo(String query) throws InterruptedException, ExecutionException {
        return nutritionLookupService.findNutritionInfo(query);
    }

    public CompletableFuture<IngredientAnalysis> getIngAnalysis(String query) throws InterruptedException, ExecutionException {
        return glLookupService.getQueryIngredients(query);
    }


}
