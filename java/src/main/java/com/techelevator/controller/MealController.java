package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.dao.MealDao;
import com.techelevator.helperclasses.NutritionApiHelper;
import com.techelevator.model.pojos.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MealController {

    private static final Logger logger = LoggerFactory.getLogger(MealController.class);
    private MealDao mealDao;
    private UserDao userDao;
    private NutritionApiHelper nutritionApiHelper;

    public MealController(MealDao mealDao, UserDao userDao, NutritionApiHelper nutritionApiHelper) {
        this.mealDao = mealDao;
        this.userDao = userDao;
        this.nutritionApiHelper = nutritionApiHelper;
    }

    @GetMapping("/meals")
    public List<Meal> returnUserMeals(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        logger.info("Returning user meals for: " + userId);
        return mealDao.getUserOneDayMeals(userId);
    }

    @PostMapping("/meals")
    public void createNewUserMeal(@RequestBody Meal mealQuery, Principal principal) {
        try {
            int userId = userDao.findIdByUsername(principal.getName());
            logger.info("Received createMealRequest for user: " + userId);
            nutritionApiHelper.handleMealCreationAndNutritionData(mealQuery.getFoodName(), mealQuery, userId);
        } catch (RuntimeException | InterruptedException | ExecutionException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create meal");
        }

    }

}
