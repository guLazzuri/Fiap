package CServicos;

import AEntidades.Artista;
import Repositorio.ArtistaRepositorio;
import Utils.Validacao.ValidadorDeEntidade;

import java.util.ArrayList;
import java.util.List;

public class ArtistaService {
    private ArtistaRepositorio artistaRepositorio;

    public ArtistaService(ArtistaRepositorio artistaRepositorio) {
        this.artistaRepositorio = artistaRepositorio;
    }

    public void cadastrarArtista(String id, String nome, String generoMusical) throws Exception {
        ValidadorDeEntidade.validarID(id);
        ValidadorDeEntidade.validarNomeDoArtista(nome);
        ValidadorDeEntidade.validarGenero(generoMusical);

        Artista artista = new Artista(id, nome, generoMusical, new ArrayList<>());
        artistaRepositorio.adicionar(artista);
    }

    public List<Artista> listar() {
        return artistaRepositorio.listar();
    }

    public void excluirPorId(String id) {
        try {
            artistaRepositorio.removerPorId(id);
            System.out.println("Artista excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir um artista!");
        }
    }

    public void atualizarPorNome(String nome, Artista novoArtista) {
        artistaRepositorio.atualizarPorNome(nome, novoArtista);
    }

    public List<Artista> buscarPorGenero(String genero) {
        List<Artista> artistasEncontrados = new ArrayList<>();
        for (Artista artista : listar()) {
            if (artista.getGeneroMusical().equalsIgnoreCase(genero)) {
                artistasEncontrados.add(artista);
            }
        }
        return artistasEncontrados;
    }
}
