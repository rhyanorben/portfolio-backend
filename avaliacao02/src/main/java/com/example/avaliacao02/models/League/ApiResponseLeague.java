package com.example.avaliacao02.models.League;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseLeague {
    private List<League> response;
    private int results;

    public List<League> getResponse() {
        return response;
    }

    public void setResponse(List<League> response) {
        this.response = response;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

}
