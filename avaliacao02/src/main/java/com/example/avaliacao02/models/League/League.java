package com.example.avaliacao02.models.League;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private LeagueDetails league;
    private Country country;

    public LeagueDetails getLeague() { return league; }

    public void setLeague(LeagueDetails league) { this.league = league; }

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }

}
