package com.techelevator.services;

import com.techelevator.model.pojos.nutritionapi.wrappers.NutritionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class NutritionLookupService {

    private static final Logger logger = LoggerFactory.getLogger(NutritionLookupService.class);
    private final String baseApiUrl = "https://api.edamam.com/api/nutrition-data";
    private String appId = "85ed73ec";
    private String PUBLIC_KEY = "e8c31b0307539eb71fd91bfeab934140";
    private String nutritionType = "logging";

    private final RestTemplate restTemplate;

    public NutritionLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<NutritionInfo> findNutritionInfo(String searchQuery) throws InterruptedException, ExecutionException {
        try {
            logger.info("Making request for: " + searchQuery);
            String url = baseApiUrl + "?app_id=" + appId + "&app_key=" + PUBLIC_KEY + "&nutrition-type=" + nutritionType + "&ingr=" + searchQuery + "&If-None-Match";
            NutritionInfo results = restTemplate.getForObject(url, NutritionInfo.class);
            return CompletableFuture.completedFuture(results);
        } catch (ResponseStatusException e) {
            throw new ExecutionException(e.getReason(), e);
        }

    }

}
