package Controller;

import AEntidades.Musica;
import CServicos.MusicaService;

import java.util.Scanner;

public class MusicaController {
    private MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    public void cadastrarMusica() {
        Scanner sc = new Scanner(System.in);

        try {
            String id = String.valueOf(0);

            System.out.println("Digite o Título da Música: ");
            String titulo = sc.nextLine();

            System.out.println("Digite o Álbum da Música: ");
            String album = sc.nextLine();

            System.out.println("Digite a Duração da Música (em segundos): ");
            int duracao = sc.nextInt();
            sc.nextLine();

            musicaService.cadastrarMusica(id, titulo, album, duracao);
            System.out.println("Música cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarMusica() {
        for (Musica musica : musicaService.listar()) {
            System.out.println(musica);
        }
    }

    public void excluirMusicaPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID da música a ser excluída: ");
        String id = sc.nextLine();
        musicaService.excluirPorId(id);
    }

    public void atualizarMusicaPorNome() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da música a ser atualizada: ");
        String nome = sc.nextLine();

        System.out.println("Digite o novo título da música: ");
        String novoTitulo = sc.nextLine();

        System.out.println("Digite o novo álbum da música: ");
        String novoAlbum = sc.nextLine();

        System.out.println("Digite a nova duração da música: ");
        int novaDuracao = sc.nextInt();
        sc.nextLine();

        Musica novaMusica = new Musica("", novoTitulo, novoAlbum, novaDuracao);
        musicaService.atualizarPorNome(nome, novaMusica);
        System.out.println("Música atualizada com sucesso!");
    }
}
