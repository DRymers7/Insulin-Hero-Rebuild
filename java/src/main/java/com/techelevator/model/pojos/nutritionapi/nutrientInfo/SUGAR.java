package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class SUGAR {

    private String label;
    private double quantity;
    private String unit;

    public SUGAR() {};

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
        SUGAR sugar = (SUGAR) o;
        return Double.compare(sugar.quantity, quantity) == 0 && Objects.equals(label, sugar.label) && Objects.equals(unit, sugar.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "SUGAR{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
