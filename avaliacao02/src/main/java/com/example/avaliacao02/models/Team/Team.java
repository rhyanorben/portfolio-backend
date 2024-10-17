package com.example.avaliacao02.models.Team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private TeamDetails team;

    public TeamDetails getTeam() { return team; }

    public void setTeam(TeamDetails team) {
        this.team = team;
    }

}
