package org.example;

public class Main {
    public static void main(String[] args) {

        Personagem jogador = new Personagem();
        jogador.nome = "Steve";
        jogador.vida = 8;

        Personagem inimigo = new Personagem();
        inimigo.nome = "Lula";
        inimigo.vida = 13;

        Kamikaze piloto = new Kamikaze();
        piloto.nome = "Piloto Japones";
        piloto.vida = 20;

        jogador.atacar(inimigo);
        piloto.atacar(inimigo);
        piloto.voar();

        System.out.println("Jogador vida: " + jogador.vida);
        System.out.println("Lula vida: " + inimigo.vida);
        System.out.println("Kamikaze vida: " + piloto.vida);

        ;
    }
}