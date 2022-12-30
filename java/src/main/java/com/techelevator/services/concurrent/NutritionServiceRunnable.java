package com.techelevator.services.concurrent;

import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.Callable;

public class NutritionServiceRunnable implements Callable<NutritionInfo> {

    private String baseApiUrl = "https://api.edamam.com/api/nutrition-data";
    private String appId = "85ed73ec";
    private String PUBLIC_KEY = "e8c31b0307539eb71fd91bfeab934140";
    private String nutritionType = "logging";
    private String searchQuery;

    public NutritionServiceRunnable(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public NutritionInfo call() throws Exception {
        return null;
    }
}
