package Repositorio;

import Entidades.Album;
import Entidades.Musica;
import Validacao.VailidadorDeEntidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AlbumRepositorio extends RepositorioGenericoImp <Album> {


    public AlbumRepositorio() {
        super(Album.class);
    }

    public void cadastrarAlbum (){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digie o ID do Albúm: ");
            String id = sc.nextLine();
            VailidadorDeEntidade.validarID(id); //alterar se usar

            System.out.println("Digite o Titúlo do Album: ");
            String titulo = sc.nextLine();
            VailidadorDeEntidade.validarTitulo(titulo); //alterar se usar

            System.out.println("Digite o Ano de Lançamento: ");
            String anoDeLancamento = sc.nextLine();
            VailidadorDeEntidade.validarAnoDoAlbum(anoDeLancamento); //alterar se usar

            System.out.println("Digite o Artista: ");
            String artista = sc.nextLine();
            VailidadorDeEntidade.validarNomeDoArtista(artista); //alterar se usar

            List<Musica> listaDeMusicas = new ArrayList<>();
            Album album = new Album(id, titulo, anoDeLancamento, artista, listaDeMusicas);
            adicionar(album);

            System.out.println("Álbum cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }
    }

    public List<Album> pesquisarPorAno(int ano){
        List<Album> albunsEncontrados = new ArrayList<>();
        for (Album album : listaDeEntidades){
            try{
                if (Integer.parseInt(album.getAnoDeLancamento()) == ano) {
                    albunsEncontrados.add(album);
                }
            }catch (NumberFormatException e){
                System.out.println("Erro: " +e.getMessage());
            }
        }
        return albunsEncontrados;
    }

}
