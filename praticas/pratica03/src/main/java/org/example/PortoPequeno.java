package org.example;

<<<<<<< HEAD
class PortoPequeno extends BasePorto {

    public PortoPequeno(String nome){
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco){
        if (barco.tamanho <= 10){
            return super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " é grande demais para " + nome);
            return false;
        }
    }
=======
public class PortoPequeno {
>>>>>>> 8657a38594cff5a7a6ca7a4b6743358d5bba5649
}
