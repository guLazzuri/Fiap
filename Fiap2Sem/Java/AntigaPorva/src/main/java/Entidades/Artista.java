package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Artista extends _EntidadeBase {
    private String nome;
    private String generoMusical;
    private List<Album> ListaDeAlguns = new ArrayList<>();

    public Artista(String id, String nome, String generoMusical, List<Album> listaDeAlguns) {
        super(id);
        this.nome = nome;
        this.generoMusical = generoMusical;
        ListaDeAlguns = listaDeAlguns;
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
        return ListaDeAlguns;
    }

    public void setListaDeAlguns(List<Album> listaDeAlguns) {
        ListaDeAlguns = listaDeAlguns;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", ListaDeAlguns=" + ListaDeAlguns +
                "} " + super.toString();
    }
}
