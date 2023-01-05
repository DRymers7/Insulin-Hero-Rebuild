package com.techelevator.dao.dao;

import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.MealInformation;
import com.techelevator.model.pojos.nutritionapi.wrappers.TotalNutrients;

import java.sql.SQLException;
import java.util.List;

public interface MealDao {

    List<Meal> getUserOneDayMeals(int userId);
    Meal getMostRecentUserMeal(int userId) throws SQLException;
    int createNewMeal(int userId, Meal meal) throws SQLException;
    void saveMealInformation(int mealId, MealInformation mealInformation) throws SQLException;

}
