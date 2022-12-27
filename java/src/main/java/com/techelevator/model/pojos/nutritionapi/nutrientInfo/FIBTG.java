package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class FIBTG {

    @JsonProperty("label")
    private String label;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("unit")
    private String unit;

    public FIBTG() {};

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
        FIBTG fibtg = (FIBTG) o;
        return Double.compare(fibtg.quantity, quantity) == 0 && Objects.equals(label, fibtg.label) && Objects.equals(unit, fibtg.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FIBTG{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
