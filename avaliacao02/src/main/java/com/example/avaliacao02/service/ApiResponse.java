package com.example.avaliacao02.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private List<Fixture> response;
    private int results;

    public List<Fixture> getResponse() {
        return response;
    }

    public void setResponse(List<Fixture> response) {
        this.response = response;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}

