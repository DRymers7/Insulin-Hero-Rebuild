package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PROCNT_KCAL {

    @JsonProperty("label")
    private String label;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("unit")
    private String unit;

    public PROCNT_KCAL() {};

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
        PROCNT_KCAL that = (PROCNT_KCAL) o;
        return Double.compare(that.quantity, quantity) == 0 && Objects.equals(label, that.label) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "PROCNT_KCAL{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
