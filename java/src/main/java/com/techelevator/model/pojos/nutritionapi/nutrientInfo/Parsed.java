package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parsed {

    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("measure")
    private String measure;
    @JsonProperty("food")
    private String food;

    public Parsed() {};

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
