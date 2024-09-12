package org.example;

class PortoPequeno extends BasePorto{
    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            return super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " é grande demais para " + nome);
            return false;
        }
    }
}
