package com.techelevator.model.pojos.glycemicloadapi.glcalculation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

    @JsonProperty("original")
    private String original;
    @JsonProperty("glycemicIndex")
    private double glycemicIndex;
    @JsonProperty("glycemicLoad")
    private double glycemicLoad;

    public Ingredient() {}

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public double getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(double glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public double getGlycemicLoad() {
        return glycemicLoad;
    }

    public void setGlycemicLoad(double glycemicLoad) {
        this.glycemicLoad = glycemicLoad;
    }
}
