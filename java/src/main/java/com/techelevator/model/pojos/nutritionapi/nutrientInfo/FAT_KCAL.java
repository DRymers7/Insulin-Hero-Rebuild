package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class FAT_KCAL {

    @JsonProperty("label")
    private String label;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("unit")
    private String unit;

    public FAT_KCAL() {};

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FAT_KCAL fat_kcal = (FAT_KCAL) o;
        return Double.compare(fat_kcal.quantity, quantity) == 0 && Objects.equals(label, fat_kcal.label) && Objects.equals(unit, fat_kcal.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FAT_KCAL{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
