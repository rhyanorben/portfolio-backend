package com.example.avaliacao02.models.Fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {
    private FixtureDetails fixture;
    @JsonProperty("teams")
    private FixtureTeams teams;
    private Goals goals;
    private FixtureLeague league;

    public FixtureDetails getFixture() {
        return fixture;
    }

    public void setFixture(FixtureDetails fixture){
        this.fixture = fixture;
    }

    public FixtureTeams getFixtureTeams() {
        return teams;
    }

    public void setFixtureTeams(FixtureTeams teams) {
        this.teams = teams;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public FixtureLeague getLeague() { return league; }

    public void setLeague(FixtureLeague league) { this.league = league; }

}