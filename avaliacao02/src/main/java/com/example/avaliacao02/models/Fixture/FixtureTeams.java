package com.example.avaliacao02.models.Fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeams {
    private FixtureTeamsDetails home;
    private FixtureTeamsDetails away;

    public FixtureTeamsDetails getHome() {
        return home;
    }

    public void setHome(FixtureTeamsDetails home) {
        this.home = home;
    }

    public FixtureTeamsDetails getAway() {
        return away;
    }

    public void setAway(FixtureTeamsDetails away) {
        this.away = away;
    }
}
