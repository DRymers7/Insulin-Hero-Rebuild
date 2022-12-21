package com.techelevator.model.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserData {

    private int userId;
    private double a1c;
    private int targetLow;
    private int targetHigh;
    private int fastingGlucose;
    private int diabetesType;
    private boolean preDiabetic;
    private int userAge;
    private int weightKg;
    private int heightM;
    private int dailyCarbGoal;
    private int dailyCalorieGoal;
    private double glycemicIndexGoal;
    private String emergencyContact1;
    private String emergencyContact2;
    private LocalDate dateLastUpdated;
    private LocalTime timeLastUpdated;
    public UserData() {};

    public UserData(int userId, double a1c, int targetLow, int targetHigh, int fastingGlucose, int diabetesType, boolean preDiabetic, int userAge, int weightKg, int heightM, int dailyCarbGoal, int dailyCalorieGoal, double glycemicIndexGoal, String emergencyContact1, String emergencyContact2, LocalDate dateLastUpdated, LocalTime timeLastUpdated) {
        this.userId = userId;
        this.a1c = a1c;
        this.targetLow = targetLow;
        this.targetHigh = targetHigh;
        this.fastingGlucose = fastingGlucose;
        this.diabetesType = diabetesType;
        this.preDiabetic = preDiabetic;
        this.userAge = userAge;
        this.weightKg = weightKg;
        this.heightM = heightM;
        this.dailyCarbGoal = dailyCarbGoal;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.glycemicIndexGoal = glycemicIndexGoal;
        this.emergencyContact1 = emergencyContact1;
        this.emergencyContact2 = emergencyContact2;
        this.dateLastUpdated = dateLastUpdated;
        this.timeLastUpdated = timeLastUpdated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getA1c() {
        return a1c;
    }

    public void setA1c(double a1c) {
        this.a1c = a1c;
    }

    public int getTargetLow() {
        return targetLow;
    }

    public void setTargetLow(int targetLow) {
        this.targetLow = targetLow;
    }

    public int getTargetHigh() {
        return targetHigh;
    }

    public void setTargetHigh(int targetHigh) {
        this.targetHigh = targetHigh;
    }

    public int getFastingGlucose() {
        return fastingGlucose;
    }

    public void setFastingGlucose(int fastingGlucose) {
        this.fastingGlucose = fastingGlucose;
    }

    public int getDiabetesType() {
        return diabetesType;
    }

    public void setDiabetesType(int diabetesType) {
        this.diabetesType = diabetesType;
    }

    public boolean isPreDiabetic() {
        return preDiabetic;
    }

    public void setPreDiabetic(boolean preDiabetic) {
        this.preDiabetic = preDiabetic;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public int getHeightM() {
        return heightM;
    }

    public void setHeightM(int heightM) {
        this.heightM = heightM;
    }

    public int getDailyCarbGoal() {
        return dailyCarbGoal;
    }

    public void setDailyCarbGoal(int dailyCarbGoal) {
        this.dailyCarbGoal = dailyCarbGoal;
    }

    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public double getGlycemicIndexGoal() {
        return glycemicIndexGoal;
    }

    public void setGlycemicIndexGoal(double glycemicIndexGoal) {
        this.glycemicIndexGoal = glycemicIndexGoal;
    }

    public String getEmergencyContact1() {
        return emergencyContact1;
    }

    public void setEmergencyContact1(String emergencyContact1) {
        this.emergencyContact1 = emergencyContact1;
    }

    public String getEmergencyContact2() {
        return emergencyContact2;
    }

    public void setEmergencyContact2(String emergencyContact2) {
        this.emergencyContact2 = emergencyContact2;
    }

    public LocalDate getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(LocalDate dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public LocalTime getTimeLastUpdated() {
        return timeLastUpdated;
    }

    public void setTimeLastUpdated(LocalTime timeLastUpdated) {
        this.timeLastUpdated = timeLastUpdated;
    }
}
