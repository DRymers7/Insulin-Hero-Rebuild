package com.techelevator.model.pojos.nutritionapi.nutrientInfo;

import java.util.Objects;

public class RIBF {

    private String label;
    private double quantity;
    private String unit;

    public RIBF() {};

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
        RIBF ribf = (RIBF) o;
        return Double.compare(ribf.quantity, quantity) == 0 && Objects.equals(label, ribf.label) && Objects.equals(unit, ribf.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unit);
    }

    @Override
    public String toString() {
        return "RIBF{" +
                "label='" + label + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
