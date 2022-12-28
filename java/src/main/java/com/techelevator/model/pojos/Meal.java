package com.techelevator.model.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meal {

    private int mealId;
    private double servingSize;
    private String unitOfMeasure;
    private String foodName;
    private LocalTime timeOfMeal;
    private LocalDate dateOfMeal;

    public Meal() {
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public LocalTime getTimeOfMeal() {
        return timeOfMeal;
    }

    public void setTimeOfMeal(LocalTime timeOfMeal) {
        this.timeOfMeal = timeOfMeal;
    }

    public LocalDate getDateOfMeal() {
        return dateOfMeal;
    }

    public void setDateOfMeal(LocalDate dateOfMeal) {
        this.dateOfMeal = dateOfMeal;
    }
}
