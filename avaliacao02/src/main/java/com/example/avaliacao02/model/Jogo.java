package com.example.avaliacao02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Jogo {
    private String data;
    private String time_casa;
    private String time_fora;
    private int gols_casa;
    private int gols_fora;
    private String status;

    public Jogo(String data, String time_casa, String time_fora, int gols_casa, int gols_fora, String status){
        this.data = data;
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
