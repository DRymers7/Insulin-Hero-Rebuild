package com.techelevator.services;

import com.techelevator.model.pojos.glycemicloadapi.glcalculation.GlycemicLoadData;
import com.techelevator.model.pojos.glycemicloadapi.recipeanalysis.IngredientAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class GLLookupService {

    private final Logger logger = LoggerFactory.getLogger(GLLookupService.class);
    private final String baseApiUrl = "https://api.spoonacular.com";
    private final String API_KEY = "32f4c3e887b54bbc8c17086836bc2b56";
    private final RestTemplate restTemplate;

    public GLLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<IngredientAnalysis> getQueryIngredients(String query) throws InterruptedException, ExecutionException {
        try {
            logger.info("Making ingredient analysis request for: " + query + " at time " + System.currentTimeMillis());
            String url = baseApiUrl + "/recipes/queries/analyze" + "?apiKey=" + API_KEY + "&q=" + query;
            IngredientAnalysis results = restTemplate.getForObject(url, IngredientAnalysis.class);
            return CompletableFuture.completedFuture(results);
        } catch (ResponseStatusException e) {
            throw new ExecutionException(e.getReason(), e);
        }
    }

    @Async
    public CompletableFuture<GlycemicLoadData> getGlycemicLoadForQuery(String query, String[] ingredients) throws InterruptedException, ExecutionException {
        try {
            logger.info("Making glycemic load calculation for " + query + " at time " + System.currentTimeMillis());
            String url = baseApiUrl + "/food/ingredients/glycemicLoad" + "?apiKey=" + API_KEY;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String[]> requestEntity = new HttpEntity<>(ingredients, headers);
            ResponseEntity<GlycemicLoadData> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, GlycemicLoadData.class);
            return CompletableFuture.completedFuture(responseEntity.getBody());
        } catch (ResponseStatusException e) {
            throw new ExecutionException(e.getReason(), e);
        }
    }

}
