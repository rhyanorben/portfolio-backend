package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {
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