package AEntidades;

import java.util.ArrayList;
import java.util.List;



public class Artista extends _EntidadeBase {
    private String nome;
    private String generoMusical;
    private List<Album> listaDeAlguns = new ArrayList<>();

    public Artista(String id, String nome, String generoMusical, List<Album> listaDeAlguns) {
        super(id);
        this.nome = nome;
        this.generoMusical = generoMusical;
        this.listaDeAlguns = listaDeAlguns;
    }

    public Artista(String nome, String generoMusical, List<Album> listaDeAlguns) {
        this.nome = nome;
        this.generoMusical = generoMusical;
        this.listaDeAlguns = listaDeAlguns;
    }

    public Artista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Album> getListaDeAlguns() {
        return listaDeAlguns;
    }

    public void setListaDeAlguns(List<Album> listaDeAlguns) {
        this.listaDeAlguns = listaDeAlguns;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", listaDeAlguns=" + listaDeAlguns +
                "} " + super.toString();
    }
}

