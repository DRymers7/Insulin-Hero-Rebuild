package com.techelevator.services;

import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class NutritionServiceThread implements Callable<NutritionInfo> {


    private final String baseApiUrl = "https://api.edamam.com/api/nutrition-data";
    private String appId = "85ed73ec";
    private String PUBLIC_KEY = "e8c31b0307539eb71fd91bfeab934140";
    private String nutritionType = "logging";
    private RestTemplate restTemplate = new RestTemplate();
    private String searchQuery;

    public NutritionServiceThread(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public NutritionInfo call() throws Exception {
        try {
            String url = baseApiUrl + "?app_id=" + appId + "&app_key=" + PUBLIC_KEY + "&nutrition-type=" + nutritionType + "&ingr=" + searchQuery + "&If-None-Match";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<NutritionInfo> requestEntity = new HttpEntity<NutritionInfo>(headers);
            ResponseEntity<NutritionInfo> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, NutritionInfo.class);
            return responseEntity.getBody();
        } catch (ResponseStatusException e) {
            throw new ExecutionException(e.getReason(), e);
        }
    }
}
