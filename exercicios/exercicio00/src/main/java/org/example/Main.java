package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] vetorPosicao = new String[4];
        vetorPosicao[0] = "atacante";
        vetorPosicao[1] = "meia";
        vetorPosicao[2] = "zagueiro";
        vetorPosicao[3] = "goleiro";

        // Também é possível realizar dessa forma:
        // String[] vetorPosicoes = {"atacante", "meia", "zagueiro", "goleiro"};

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu primeiro nome: ");
        String primeiroNome = leitor.nextLine();

        if (primeiroNome.isEmpty()) return;

        System.out.println("Digite seu segundo nome: ");
        String segundoNome = leitor.nextLine();

        Random geradorAleatorio = new Random();
        Integer numeroAleatorio = geradorAleatorio.nextInt(10, 100);

        Integer indiceAleatorio = geradorAleatorio.nextInt(vetorPosicao.length);
        String posicao = vetorPosicao[indiceAleatorio];

        System.out.println(primeiroNome + segundoNome + numeroAleatorio + posicao);
    }
}