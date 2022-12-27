package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class FAPU {

    private String label;
    private double quantity;
    private String unit;

    public FAPU() {};

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
        FAPU fapu = (FAPU) o;
        return Double.compare(fapu.quantity, quantity) == 0 && Objects.equals(label, fapu.label) && Objects.equals(unit, fapu.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "FAPU{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
