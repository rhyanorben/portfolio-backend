package org.example;

import java.util.Scanner;

public class Recomendador {
    private Pergunta pergunta1;
    private Pergunta pergunta2;

    public Recomendador() {
        pergunta1 = new Pergunta("Que ambientação você prefere?",
                new String[]{"Sci-fi", "Medieval"});
        pergunta2 = new Pergunta("Que gênero você prefere?",
                new String[]{"Comédia", "Drama"});
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        int resposta1 = perguntar(scanner, pergunta1);
        if (resposta1 == -1) return;

        int resposta2 = perguntar(scanner, pergunta2);
        if (resposta2 == -1) return;

        recomendar(resposta1, resposta2);
        scanner.close();
    }

    private int perguntar(Scanner scanner, Pergunta pergunta) {
        pergunta.exibir();
        int resposta = scanner.nextInt();
        if (!pergunta.validarResposta(resposta)) {
            System.out.println("Resposta inválida. Programa encerrado.");
            return -1;
        }
        return resposta;
    }

    private void recomendar(int resposta1, int resposta2) {
        if (resposta1 == 1 && resposta2 == 1) {
            System.out.println("Recomendação: Homens de Preto");
        } else if (resposta1 == 1 && resposta2 == 2) {
            System.out.println("Recomendação: Arrival");
        } else if (resposta1 == 2 && resposta2 == 1) {
            System.out.println("Recomendação: Shrek");
        } else if (resposta1 == 2 && resposta2 == 2) {
            System.out.println("Recomendação: Gladiador");
        }
    }
}
