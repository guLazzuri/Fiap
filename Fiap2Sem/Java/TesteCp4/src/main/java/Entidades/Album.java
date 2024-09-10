package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Album extends _EntidadeBase{
    private String titulo;
    private String anoDeLancamento;
    private String artista;
    private List<Musica> listaDeMusicas = new ArrayList<>();

    public Album(String id, String titulo, String anoDeLancamento, String artista, List<Musica> listaDeMusicas) {
        super(id);
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.artista = artista;
        this.listaDeMusicas = listaDeMusicas;
    }

    public Album(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public List<Musica> getListaDeMusicas() {
        return listaDeMusicas;
    }

    public void setListaDeMusicas(List<Musica> listaDeMusicas) {
        this.listaDeMusicas = listaDeMusicas;
    }

    @Override
    public String toString() {
        return "Album{" +
                "titulo='" + titulo + '\'' +
                ", anoDeLancamento='" + anoDeLancamento + '\'' +
                ", artista='" + artista + '\'' +
                ", listaDeMusicas=" + listaDeMusicas +
                "} " + super.toString();
    }
}
