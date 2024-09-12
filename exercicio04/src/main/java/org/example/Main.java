package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Musica musica = new Musica("Não deixa o samba morrer", "Alcione");
//        musica.setTitulo("Não deixa o samba morrer");
//        musica.setArtista("Alcione");

        RepositorioMusica emule = new RepositorioMusica();
        emule.adicionarMusica("Bota na pipokinha", "Pipokinha");
        emule.adicionarMusica("Voando Alto", "MC Poze");
        emule.adicionarMusica("Do fundo da grota", "Baitaca");
        emule.adicionarMusica("Festa", "Ivete Sangalo");
        emule.adicionarMusica("Melhor eu ir", "Pericles");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Digite o nome da música: ");
            String termo = scanner.nextLine();


            try {
                Musica musicaPesquisada = emule.buscarMusica(termo);
                System.out.println(musicaPesquisada.getTitulo() + " - " + musicaPesquisada.getArtista());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

