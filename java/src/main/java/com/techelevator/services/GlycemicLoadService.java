package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

public class GlycemicLoadService {

    private String baseApiUrl;
    private String API_KEY;

    RestTemplate restTemplate = new RestTemplate();

    public GlycemicLoadService(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
    }





}
