package com.techelevator.model.pojos.nutritionapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.pojos.nutritionapi.nutrientInfo.Parsed;

import java.util.List;

public class Ingredients {

    @JsonProperty("text")
    private String text;

    @JsonProperty("parsed")
    private Parsed[] parsed;

    public Ingredients() {};

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Parsed[] getParsed() {
        return parsed;
    }

    public void setParsed(Parsed[] parsed) {
        this.parsed = parsed;
    }
}
