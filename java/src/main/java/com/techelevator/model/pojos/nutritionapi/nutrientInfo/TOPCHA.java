package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class TOPCHA {

    private String label;
    private double quantity;
    private String unit;

    public TOPCHA() {};

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
        TOPCHA topcha = (TOPCHA) o;
        return Double.compare(topcha.quantity, quantity) == 0 && Objects.equals(label, topcha.label) && Objects.equals(unit, topcha.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "TOPCHA{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
