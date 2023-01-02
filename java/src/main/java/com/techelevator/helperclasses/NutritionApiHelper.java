package com.techelevator.helperclasses;

import com.techelevator.dao.dao.MealDao;
import com.techelevator.services.NutritionLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class NutritionApiHelper {

    private static final Logger logger = LoggerFactory.getLogger(NutritionApiHelper.class);
    private final NutritionLookupService nutritionLookupService;
    private MealDao mealDao;

    public NutritionApiHelper(NutritionLookupService nutritionLookupService, MealDao mealDao) {
        this.nutritionLookupService = nutritionLookupService;
        this.mealDao = mealDao;
    }




}
