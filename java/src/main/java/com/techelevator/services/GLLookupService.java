package com.techelevator.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GLLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GLLookupService.class);
    private final String baseApiUrl = "https://api.spoonacular.com";
    private final String API_KEY = "32f4c3e887b54bbc8c17086836bc2b56";
    private final RestTemplate restTemplate;

    public GLLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }




}