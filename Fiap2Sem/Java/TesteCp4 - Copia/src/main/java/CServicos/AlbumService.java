package CServicos;


import Repositorio.AlbumRepositorio;
import Utils.Validacao.ValidadorDeEntidade;

public class AlbumService {
    private AlbumRepositorio albumRepositorio;

    public AlbumService(AlbumRepositorio albumRepositorio) {
        this.albumRepositorio = albumRepositorio;
    }

    public void cadastrarAlbum(String id, String titulo, int anoDeLancamento, String artista, List<Musica> listaDeMusicas) throws Exception {
        // Realizar validações
        ValidadorDeEntidade.validarID(id);
        ValidadorDeEntidade.validarTitulo(titulo);
        ValidadorDeEntidade.validarAnoDoAlbum(anoDeLancamento);
        ValidadorDeEntidade.validarNomeDoArtista(artista);

        Album album = new Album(id, titulo, anoDeLancamento, artista, listaDeMusicas);
        albumRepositorio.adicionar(album);
    }


    public List<Album> Listar() {
        return albumRepositorio.listar();
    }

    public void excluirPorId(String id) {
        try {
            albumRepositorio.removerPorId(id);
            System.out.println("Álbum excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir um album!");
        }
    }

    public void atualizarPorNome(String nome, Album novoAlbum) {
        albumRepositorio.atualizarPorNome(nome, novoAlbum);
    }



    public List<Album> buscarPorAno(int ano) {
        List<Album> albumEcontrados = new ArrayList<>();
        for (Album album : Listar()) {
            if (album.getAnoDeLancamento() == ano) {
                albumEcontrados.add(album);
            }
        }
        return albumEcontrados;
    }




}
