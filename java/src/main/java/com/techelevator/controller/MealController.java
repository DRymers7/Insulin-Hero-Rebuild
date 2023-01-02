package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.dao.MealDao;
import com.techelevator.helperclasses.NutritionApiHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MealController {

    private MealDao mealDao;
    private UserDao userDao;
    private NutritionApiHelper nutritionApiHelper;

    public MealController(MealDao mealDao, UserDao userDao, NutritionApiHelper nutritionApiHelper) {
        this.mealDao = mealDao;
        this.userDao = userDao;
        this.nutritionApiHelper = nutritionApiHelper;
    }



}
