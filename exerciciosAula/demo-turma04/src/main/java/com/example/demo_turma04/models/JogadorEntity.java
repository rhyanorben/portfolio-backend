package com.example.demo_turma04.models;

public class JogadorEntity {

    private String nome;
    private String apelido;
    private String posicao;
    private Integer idade;
    private Integer habilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Integer habilidade) {
        this.habilidade = habilidade;
    }
}
