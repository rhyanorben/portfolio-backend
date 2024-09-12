package org.example;

public class Musica {

    private String titulo;
    private String artista;

    public Musica(String tituloConstrutor, String artistaConstrutor){
        this.titulo = tituloConstrutor;
        this.artista = artistaConstrutor;
    }

    public String getArtista () {
        return this.artista;
    }

    public String getTitulo () {
        return this.titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public void setArtista (String artista) {
        this.artista = artista;
    }

}
