package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class NIA {

    private String label;
    private double quantity;
    private String unit;

    public NIA() {};

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
        NIA nia = (NIA) o;
        return Double.compare(nia.quantity, quantity) == 0 && Objects.equals(label, nia.label) && Objects.equals(unit, nia.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "NIA{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
