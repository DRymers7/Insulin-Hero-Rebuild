package com.techelevator.model.pojos.glycemicloadapi.recipeanalysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientAnalysis {

    @JsonProperty("ingredients")
    private Ingredients[] ingredients;

    public IngredientAnalysis() {}

    public Ingredients[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients[] ingredients) {
        this.ingredients = ingredients;
    }
}
