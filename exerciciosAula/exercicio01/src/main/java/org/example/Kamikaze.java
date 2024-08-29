package org.example;

public class Kamikaze extends Personagem{
    @Override

    public void atacar(Personagem alvo){
        alvo.vida -= 20;
        this.vida = 0;
    }

    public void voar () {

    }
}
