package com.techelevator.model.pojos.glycemicloadapi.glcalculation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlycemicLoadData {

    @JsonProperty("totalGlycemicLoad")
    private double totalGlycemicLoad;

    @JsonProperty("ingredients")
    private Ingredient[] ingredients;

    public GlycemicLoadData() {}

    public double getTotalGlycemicLoad() {
        return totalGlycemicLoad;
    }

    public void setTotalGlycemicLoad(double totalGlycemicLoad) {
        this.totalGlycemicLoad = totalGlycemicLoad;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }
}
