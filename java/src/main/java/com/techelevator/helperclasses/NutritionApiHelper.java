package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import com.techelevator.services.NutritionService;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NutritionApiHelper {

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private NutritionService nutritionService = new NutritionService("https://api.edamam.com/api/nutrition-data");
    private MealDao mealDao;

    public NutritionApiHelper(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    //1. Call edamam get nutri info
    // 2. call spoonacular and get glycemic load for

//    public void runOperations(String searchQuery) throws ResponseStatusException {
//        executorService.submit(new NutritionServiceRunnable(searchQuery));
//    }
//
//    private NutritionInfo getNutritionDataFromApi(String foodName) throws Exception {
//        return null;
//    }

    public void testMethod() throws Exception {

        List<Future<>>
    }












    public Meal handleUserMealCreation(int userId, Meal meal) throws SQLException, ResponseStatusException {
        NutritionInfo nutritionInfo = getNutritionInfoFromApi(meal.getFoodName());
        System.out.println("Placeholder for spoonacular call");
        setMealServingSize(meal, nutritionInfo);
        preprocessMealObject(meal);
        int mealId = createUserMeal(userId, meal);

        return null;
    }

    private NutritionInfo getNutritionInfoFromApi(String query) throws ResponseStatusException {
        return null;
    }

    private void setMealServingSize(Meal meal, NutritionInfo nutritionInfo) {

        Arrays.stream(nutritionInfo.getIngredients()).forEach(ingredients -> Arrays.stream(ingredients.getParsed()).sequential().forEach(element -> {
            meal.setServingSize(element.getQuantity());
            meal.setUnitOfMeasure(element.getMeasure());
        }));

    }

    private void preprocessMealObject(Meal meal) {

        if (meal.getTimeOfMeal() == null) {
            meal.setTimeOfMeal(LocalTime.now());
        }
        if (meal.getDateOfMeal() == null) {
            meal.setDateOfMeal(LocalDate.now());
        }
    }

    private int createUserMeal(int userId, Meal meal) throws SQLException {
        return mealDao.createNewMeal(userId, meal);
    }


}
