package com.techelevator.model.pojos;

import java.time.LocalTime;
import java.time.LocalDate;

public class BloodSugar {

    int bloodSugarId;
    int inputLevel;
    LocalTime timeOfMeasurement;
    LocalDate dateOfMeasurement;

    public BloodSugar() {
    }

    public BloodSugar(int bloodSugarId, int inputLevel, LocalTime timeOfMeasurement, LocalDate dateOfMeasurement) {
        this.bloodSugarId = bloodSugarId;
        this.inputLevel = inputLevel;
        this.timeOfMeasurement = timeOfMeasurement;
        this.dateOfMeasurement = dateOfMeasurement;
    }

    public int getBloodSugarId() {
        return bloodSugarId;
    }

    public void setBloodSugarId(int bloodSugarId) {
        this.bloodSugarId = bloodSugarId;
    }

    public int getInputLevel() {
        return inputLevel;
    }

    public void setInputLevel(int inputLevel) {
        this.inputLevel = inputLevel;
    }

    public LocalTime getTimeOfMeasurement() {
        return timeOfMeasurement;
    }

    public void setTimeOfMeasurement(LocalTime timeOfMeasurement) {
        this.timeOfMeasurement = timeOfMeasurement;
    }

    public LocalDate getDateOfMeasurement() {
        return dateOfMeasurement;
    }

    public void setDateOfMeasurement(LocalDate dateOfMeasurement) {
        this.dateOfMeasurement = dateOfMeasurement;
    }
}
