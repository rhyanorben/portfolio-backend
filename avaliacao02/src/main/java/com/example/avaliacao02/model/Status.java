package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    @JsonProperty("long")
    private String longStatus;
    @JsonProperty("short")
    private String shortStatus;
    private int elapsed;

    public String getLongStatus() {
        return longStatus;
    }

    public void setLongStatus(String longStatus) {
        this.longStatus = longStatus;
    }

    public String getShortStatus() {
        return shortStatus;
    }

    public void setShortStatus(String shortStatus) {
        this.shortStatus = shortStatus;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }
}
