package com.techelevator.services;

import com.techelevator.model.pojos.nutritionapi.NutritionInfo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NutritionService {

    private String baseApiUrl;
    private String appId = "85ed73ec";
    private String PUBLIC_KEY = "e8c31b0307539eb71fd91bfeab934140";
    private String nutritionType = "logging";

    RestTemplate restTemplate = new RestTemplate();

    public NutritionService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }

    public NutritionInfo getListOfQueriedFoods(String searchQuery) {
        String url = baseApiUrl + "?app_id=" + appId + "&app_key=" + PUBLIC_KEY + "&nutrition-type=" + nutritionType + "&ingr=" + searchQuery + "&If-None-Match";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NutritionInfo> requestEntity = new HttpEntity<NutritionInfo>(headers);
        ResponseEntity<NutritionInfo> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, NutritionInfo.class);
        return responseEntity.getBody();
    }
}
