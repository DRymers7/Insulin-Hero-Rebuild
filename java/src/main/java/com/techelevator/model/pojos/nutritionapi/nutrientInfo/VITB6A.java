package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class VITB6A {

    private String label;
    private double quantity;
    private String unit;

    public VITB6A() {};

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
        VITB6A vitb6A = (VITB6A) o;
        return Double.compare(vitb6A.quantity, quantity) == 0 && Objects.equals(label, vitb6A.label) && Objects.equals(unit, vitb6A.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "VITB6A{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
