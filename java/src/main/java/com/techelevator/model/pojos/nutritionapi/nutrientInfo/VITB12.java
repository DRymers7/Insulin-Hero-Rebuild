package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class VITB12 {

    private String label;
    private double quantity;
    private String unit;

    public VITB12() {};

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
        VITB12 vitb12 = (VITB12) o;
        return Double.compare(vitb12.quantity, quantity) == 0 && Objects.equals(label, vitb12.label) && Objects.equals(unit, vitb12.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "VITB12{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
