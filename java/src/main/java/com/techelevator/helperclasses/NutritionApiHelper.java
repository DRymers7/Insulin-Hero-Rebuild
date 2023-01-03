package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;
import com.techelevator.services.GLLookupService;
import com.techelevator.services.NutritionLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    public void handleMealCreationAndNutritionData(String query, int userId) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        logger.info("Start time for operation: " + startTime);
        CompletableFuture<NutritionInfo> nutritionInfo = getNutritionInfo(query);
        CompletableFuture<IngredientAnalysis> ingredientAnalysis = getIngredientAnalysis(query).thenApply((ingredient) -> {

        })

    }

    private CompletableFuture<NutritionInfo> getNutritionInfoObject(String query) throws InterruptedException, ExecutionException {
        return nutritionLookupService.findNutritionInfo(query);
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
