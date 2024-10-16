package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
    private String data;
    private String liga;
    private int minutes;
    private String time_casa;
    private String time_fora;
    private int gols_casa;
    private int gols_fora;
    private String status;

    public Game(String data, String liga, int minutes, String time_casa, String time_fora, int gols_casa, int gols_fora, String status){
        this.data = data;
        this.liga = liga;
        this.minutes = minutes;
        this.time_casa = time_casa;
        this.time_fora = time_fora;
        this.gols_casa = gols_casa;
        this.gols_fora = gols_fora;
        this.status = status;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga){
        this.liga = liga;
    }

    public int getMinutes(){
        return minutes;
    }

    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    public String getTime_casa() {
        return time_casa;
    }

    public void setTime_casa(String time_casa){
        this.time_casa = time_casa;
    }

    public String getTime_fora() {
        return time_fora;
    }

    public void setTime_fora(String time_fora){
        this.time_fora = time_fora;
    }

    public int getGols_casa() {
        return gols_casa;
    }

    public void setGols_casa(int gols_casa) {
        this.gols_casa = gols_casa;
    }

    public int getGols_fora() {
        return gols_fora;
    }

    public void setGols_fora(int gols_fora) {
        this.gols_fora = gols_fora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
