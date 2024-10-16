package com.example.avaliacao02.models.Team;

import com.example.avaliacao02.models.Fixture.FixtureTeams;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseTeam {
    private List<Team> response;
    private int results;

    public List<Team> getResponse() {
        return response;
    }

    public void setResponse(List<Team> response) {
        this.response = response;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }


}
