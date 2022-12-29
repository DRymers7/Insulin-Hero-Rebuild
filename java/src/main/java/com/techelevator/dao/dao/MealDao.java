package com.techelevator.dao.dao;

import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.TotalNutrients;

import java.sql.SQLException;

public interface MealDao {

    int createNewMeal(int userId, Meal meal) throws SQLException;
    void saveMealInformation(int mealId, TotalNutrients totalNutrients, Meal meal) throws SQLException;

}
