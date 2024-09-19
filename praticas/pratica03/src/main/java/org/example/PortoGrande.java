package org.example;

<<<<<<< HEAD
class PortoGrande extends BasePorto{
    public PortoGrande(Barco barco){
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco){
        if (barco.tamanho > 10) {
            return super.atracarBarco(barco);
        } else{
            System.out.println(barco.nome + " é pequeno demais para atracar no " + nome);
            return false;
        }
    }
=======
public class PortoGrande {
>>>>>>> 8657a38594cff5a7a6ca7a4b6743358d5bba5649
}
