package org.example;

public class Pergunta {
    private String texto;
    private String[] opcoes;

    public Pergunta(String texto, String[] opcoes) {
        this.texto = texto;
        this.opcoes = opcoes;
    }

    public void exibir() {
        System.out.println(texto);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + ". " + opcoes[i]);
        }
    }

    public boolean validarResposta(int resposta) {
        return resposta >= 1 && resposta <= opcoes.length;
    }
}
