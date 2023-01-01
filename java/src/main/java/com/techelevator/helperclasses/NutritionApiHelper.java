package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.model.pojos.Meal;
import com.techelevator.model.pojos.nutritionapi.NutritionInfo;

import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class NutritionApiHelper {

    private MealDao mealDao;

    public NutritionApiHelper(MealDao mealDao) {
        this.mealDao = mealDao;
    }




}
