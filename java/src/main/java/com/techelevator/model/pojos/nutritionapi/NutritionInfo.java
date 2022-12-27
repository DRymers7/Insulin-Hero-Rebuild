package com.techelevator.model.pojos.nutritionapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

public class NutritionInfo {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("calories")
    private int calories;
    @JsonProperty("totalWeight")
    private double totalWeight;
    @JsonProperty("dietLabels")
    private String[] dietLabels;
    @JsonProperty("healthLabels")
    private String[] healthLabels;
    @JsonProperty("cautions")
    private String[] cautions;
    @JsonProperty("totalNutrients")
    private TotalNutrients totalNutrients;
    @JsonProperty("totalDaily")
    private TotalDaily totalDaily;
    @JsonProperty("totalNutrientsKCal")
    private TotalNutrientsKCal totalNutrientsKCal;

    public NutritionInfo() {}

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String[] getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(String[] dietLabels) {
        this.dietLabels = dietLabels;
    }

    public String[] getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(String[] healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String[] getCautions() {
        return cautions;
    }

    public void setCautions(String[] cautions) {
        this.cautions = cautions;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public TotalNutrientsKCal getTotalNutrientsKCal() {
        return totalNutrientsKCal;
    }

    public void setTotalNutrientsKCal(TotalNutrientsKCal totalNutrientsKCal) {
        this.totalNutrientsKCal = totalNutrientsKCal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionInfo that = (NutritionInfo) o;
        return calories == that.calories && Double.compare(that.totalWeight, totalWeight) == 0 && Objects.equals(uri, that.uri) && Arrays.equals(dietLabels, that.dietLabels) && Arrays.equals(healthLabels, that.healthLabels) && Arrays.equals(cautions, that.cautions) && Objects.equals(totalNutrients, that.totalNutrients) && Objects.equals(totalDaily, that.totalDaily) && Objects.equals(totalNutrientsKCal, that.totalNutrientsKCal);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uri, calories, totalWeight, totalNutrients, totalDaily, totalNutrientsKCal);
        result = 31 * result + Arrays.hashCode(dietLabels);
        result = 31 * result + Arrays.hashCode(healthLabels);
        result = 31 * result + Arrays.hashCode(cautions);
        return result;
    }

    @Override
    public String toString() {
        return "NutritionInfo{" +
                "uri='" + uri + '\'' +
                ", calories=" + calories +
                ", totalWeight=" + totalWeight +
                ", dietLabels=" + Arrays.toString(dietLabels) +
                ", healthLabels=" + Arrays.toString(healthLabels) +
                ", cautions=" + Arrays.toString(cautions) +
                ", totalNutrients=" + totalNutrients +
                ", totalDaily=" + totalDaily +
                ", totalNutrientsKCal=" + totalNutrientsKCal +
                '}';
    }
}
