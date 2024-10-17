package com.example.avaliacao02.models.Fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeamsDetails {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
