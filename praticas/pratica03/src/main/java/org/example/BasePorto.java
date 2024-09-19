package org.example;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

class BasePorto {
    String nome;
    List<Barco> barcosAtracados;

    public BasePorto(String nome){
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public boolean atracarBarco(Barco barco){
        barcosAtracados.add(barco);
        System.out.println(barco.nome + " atracado no " + nome);
        return true;
    }

    public void desatracarBarco(Barco barco){
        barcosAtracados.remove(barco);
        System.out.println(barco.nome + "desatracado do " + nome);
    }
=======
public class BasePorto {
>>>>>>> 8657a38594cff5a7a6ca7a4b6743358d5bba5649
}
