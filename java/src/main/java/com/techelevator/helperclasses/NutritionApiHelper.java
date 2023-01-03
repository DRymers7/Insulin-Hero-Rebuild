package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.glycemicloadapi.glcalculation.GlycemicLoadData;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;
import com.techelevator.services.GLLookupService;
import com.techelevator.services.NutritionLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
    private final int ONE_SERVING_CARBOHYDRATES = 15;

    public NutritionApiHelper(NutritionLookupService nutritionLookupService, GLLookupService glLookupService, MealDao mealDao) {
        this.nutritionLookupService = nutritionLookupService;
        this.glLookupService = glLookupService;
        this.mealDao = mealDao;
    }

    public void handleMealCreationAndNutritionData(String query, Meal meal, int userId) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        logger.info("Start time for meal creation and nutrition data operation: " + startTime);

        CompletableFuture<NutritionInfo> nutritionInfo = handleNutritionalInformationCall(query, meal, userId);


        CompletableFuture<IngredientAnalysis> ingredientAnalysis = getIngredientAnalysis(query).thenApply((ingredient) -> {
            List<String> ingredientList = new ArrayList<>();
            Arrays.stream(ingredient.getIngredients()).forEach((i) -> {
                if (i.isInclude()) {
                    ingredientList.add(i.getName());
                }
            });
        })

    }

    private CompletableFuture<NutritionInfo> handleNutritionalInformationCall(String query, Meal meal, int userId) throws InterruptedException, ExecutionException {
        return nutritionLookupService.findNutritionInfo(query).thenApply((returnValue) -> {
            Meal mealToInsert = createMealFromObject(query, meal, returnValue);

        })
    }

    private Meal createMealFromObject(String query, Meal meal, NutritionInfo nutritionInfo) {
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

    private CompletableFuture<GlycemicLoadData> calculateGlycemicLoad(String query, String[] ingredients) throws InterruptedException, ExecutionException {
        return glLookupService.getGlycemicLoadForQuery(query, ingredients);
    }


    private CompletableFuture<IngredientAnalysis> getIngredientAnalysis(String query) throws InterruptedException, ExecutionException {
        return glLookupService.getQueryIngredients(query);
    }



    public CompletableFuture<NutritionInfo> getNutritionInfo(String query) throws InterruptedException, ExecutionException {
        return nutritionLookupService.findNutritionInfo(query);
    }

    public CompletableFuture<IngredientAnalysis> getIngAnalysis(String query) throws InterruptedException, ExecutionException {
        return glLookupService.getQueryIngredients(query);
    }


}
