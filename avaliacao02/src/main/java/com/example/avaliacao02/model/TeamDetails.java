package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDetails {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ApiResponse {
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Fixture {
        private FixtureDetails fixture;
        private Team teams;
        private Goals goals;
        private League league;

        public FixtureDetails getFixture() {
            return fixture;
        }

        public void setFixture(FixtureDetails fixture){
            this.fixture = fixture;
        }

        public Team getTeams() {
            return teams;
        }

        public void setTeams(Team teams) {
            this.teams = teams;
        }

        public Goals getGoals() {
            return goals;
        }

        public void setGoals(Goals goals) {
            this.goals = goals;
        }

        public League getLeague() { return league; }

        public void setLeague(League league) { this.league = league; }

    }
}
