package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class VITK1 {

    private String label;
    private double quantity;
    private String unit;

    public VITK1() {};

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
        VITK1 vitk1 = (VITK1) o;
        return Double.compare(vitk1.quantity, quantity) == 0 && Objects.equals(label, vitk1.label) && Objects.equals(unit, vitk1.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "VITK1{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
