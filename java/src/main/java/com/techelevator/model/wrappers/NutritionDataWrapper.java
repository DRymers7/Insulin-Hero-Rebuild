package com.techelevator.model.wrappers;

import com.techelevator.model.pojos.glycemicloadapi.glcalculation.GlycemicLoadData;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;

public class NutritionDataWrapper {

    private NutritionInfo nutritionInfo;
    private IngredientAnalysis ingredientAnalysis;
    private GlycemicLoadData glycemicLoadData;

    public NutritionDataWrapper() {}

    public NutritionInfo getNutritionInfo() {
        return nutritionInfo;
    }

    public void setNutritionInfo(NutritionInfo nutritionInfo) {
        this.nutritionInfo = nutritionInfo;
    }

    public IngredientAnalysis getIngredientAnalysis() {
        return ingredientAnalysis;
    }

    public void setIngredientAnalysis(IngredientAnalysis ingredientAnalysis) {
        this.ingredientAnalysis = ingredientAnalysis;
    }

    public GlycemicLoadData getGlycemicLoadData() {
        return glycemicLoadData;
    }

    public void setGlycemicLoadData(GlycemicLoadData glycemicLoadData) {
        this.glycemicLoadData = glycemicLoadData;
    }
}
