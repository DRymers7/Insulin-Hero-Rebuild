package com.techelevator.helperclasses;

import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import com.techelevator.services.NutritionService;

public class NutritionApiHelper {

    private NutritionService nutritionService = new NutritionService("https://api.edamam.com/api/nutrition-data");

    public NutritionApiHelper() {}

    public NutritionInfo getNutritionInfo(String ingredient) {
        NutritionInfo nutritionInfo = nutritionService.getNutritionalInformation(ingredient);
        return null;
    }


}
