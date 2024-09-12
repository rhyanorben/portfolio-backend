package org.example;

class PortoGrande extends BasePorto{
    public PortoGrande(String nome){
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho >= 10) {
            return super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " é pequeno demais para " + nome);
            return false;
        }
    }
}
