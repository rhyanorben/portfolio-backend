package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private TeamDetails home;
    private TeamDetails away;

    // Getters e Setters
    public TeamDetails getHome() {
        return home;
    }

    public void setHome(TeamDetails home) {
        this.home = home;
    }

    public TeamDetails getAway() {
        return away;
    }

    public void setAway(TeamDetails away) {
        this.away = away;
    }
}
