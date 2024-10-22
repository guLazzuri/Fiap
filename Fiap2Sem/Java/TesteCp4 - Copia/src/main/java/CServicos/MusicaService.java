package CServicos;

import AEntidades.Musica;
import Repositorio.MusicaRepositorio;
import Utils.Validacao.ValidadorDeEntidade;

import java.util.List;

public class MusicaService {
    private MusicaRepositorio musicaRepositorio;

    public MusicaService(MusicaRepositorio musicaRepositorio) {
        this.musicaRepositorio = musicaRepositorio;
    }

    public void cadastrarMusica(String id, String titulo, String album, int duracao) throws Exception {
        // Realizar validações
        ValidadorDeEntidade.validarID(id);
        ValidadorDeEntidade.validarTitulo(titulo);
        ValidadorDeEntidade.validarAlbum(album);
        ValidadorDeEntidade.validarDuracao(duracao);

        Musica musica = new Musica(id, titulo, album, duracao);
        musicaRepositorio.adicionar(musica);
    }

    public List<Musica> listar() {
        return musicaRepositorio.listar();
    }

    public void excluirPorId(String id) {
        try {
            musicaRepositorio.removerPorId(id);
            System.out.println("Música excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir a música!");
        }
    }

    public void atualizarPorNome(String nome, Musica novaMusica) {
        musicaRepositorio.atualizarPorNome(nome, novaMusica);
    }

}
