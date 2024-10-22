package Controller;

import AEntidades.Album;
import AEntidades.Musica;
import CServicos.AlbumService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    public void cadastrarAlbum() {
        Scanner sc = new Scanner(System.in);

        try {
            String id = String.valueOf(0);

            System.out.println("Digite o Título do Album: ");
            String titulo = sc.nextLine();

            System.out.println("Digite o Ano de Lançamento: ");
            int anoDeLancamento = sc.nextInt();
            sc.nextLine();  // Consumir nova linha

            System.out.println("Digite o Artista do Album: ");
            String artista = sc.nextLine();

            List<Musica> listaDeMusicas = new ArrayList<>();

            albumService.cadastrarAlbum(id, titulo, anoDeLancamento, artista, listaDeMusicas);
            System.out.println("Album cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarAlbum() {
        for (Album album : albumService.Listar()) {
            System.out.println(album);
        }
    }

    public void excluirAlbumPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do álbum a ser excluído: ");
        String id = sc.nextLine();
        albumService.excluirPorId(id);
    }


    public void atualizarAlbumPorNome() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do álbum a ser atualizado: ");
        String nome = sc.nextLine();

        System.out.println("Digite o novo título do álbum: ");
        String novoTitulo = sc.nextLine();

        System.out.println("Digite o novo ano de lançamento: ");
        int novoAno = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o novo artista do álbum: ");
        String novoArtista = sc.nextLine();

        Album novoAlbum = new Album("", novoTitulo, novoAno, novoArtista, new ArrayList<>());
        albumService.atualizarPorNome(nome, novoAlbum);
        System.out.println("Álbum atualizado com sucesso!");
    }


}
