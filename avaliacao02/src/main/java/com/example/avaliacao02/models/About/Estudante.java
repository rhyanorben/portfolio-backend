package com.example.avaliacao02.models.About;


public class Estudante {
    private String nome = "Rhyan Willemann Orben";
    private String trabalho = "Pesquisa de Jogos";

    public Estudante(String nome, String trabalho) {
        this.nome = nome;
        this.trabalho = trabalho;
    }

        public String getNome(){
            return nome;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public String getTrabalho(){
            return trabalho;
        }

        public void setTrabalho(String trabalho){
            this.trabalho = trabalho;
        }
    }
