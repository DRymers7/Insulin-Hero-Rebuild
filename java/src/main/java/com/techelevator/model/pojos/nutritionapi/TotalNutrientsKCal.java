package com.techelevator.model.pojos.nutritionapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.ModelClasses.edamam.nutrientInfo.CHOCDF_KCAL;
import com.techelevator.model.ModelClasses.edamam.nutrientInfo.ENERC_KCAL;
import com.techelevator.model.ModelClasses.edamam.nutrientInfo.FAT_KCAL;
import com.techelevator.model.ModelClasses.edamam.nutrientInfo.PROCNT_KCAL;

import java.util.Objects;

public class TotalNutrientsKCal {

    @JsonProperty("ENERC_KCAL")
    private ENERC_KCAL enerc_kcal;
    @JsonProperty("PROCNT_KCAL")
    private PROCNT_KCAL procnt_kcal;
    @JsonProperty("FAT_KCAL")
    private FAT_KCAL fat_kcal;
    @JsonProperty("CHOCDF_KCAL")
    private CHOCDF_KCAL chocdf_kcal;

    public TotalNutrientsKCal() {};

    public ENERC_KCAL getEnerc_kcal() {
        return enerc_kcal;
    }

    public void setEnerc_kcal(ENERC_KCAL enerc_kcal) {
        this.enerc_kcal = enerc_kcal;
    }

    public PROCNT_KCAL getProcnt_kcal() {
        return procnt_kcal;
    }

    public void setProcnt_kcal(PROCNT_KCAL procnt_kcal) {
        this.procnt_kcal = procnt_kcal;
    }

    public FAT_KCAL getFat_kcal() {
        return fat_kcal;
    }

    public void setFat_kcal(FAT_KCAL fat_kcal) {
        this.fat_kcal = fat_kcal;
    }

    public CHOCDF_KCAL getChocdf_kcal() {
        return chocdf_kcal;
    }

    public void setChocdf_kcal(CHOCDF_KCAL chocdf_kcal) {
        this.chocdf_kcal = chocdf_kcal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalNutrientsKCal that = (TotalNutrientsKCal) o;
        return Objects.equals(enerc_kcal, that.enerc_kcal) && Objects.equals(procnt_kcal, that.procnt_kcal) && Objects.equals(fat_kcal, that.fat_kcal) && Objects.equals(chocdf_kcal, that.chocdf_kcal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enerc_kcal, procnt_kcal, fat_kcal, chocdf_kcal);
    }

    @Override
    public String toString() {
        return "TotalNutrientsKCal{" +
                "enerc_kcal=" + enerc_kcal +
                ", procnt_kcal=" + procnt_kcal +
                ", fat_kcal=" + fat_kcal +
                ", chocdf_kcal=" + chocdf_kcal +
                '}';
    }
}
