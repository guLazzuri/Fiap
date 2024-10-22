package Controller;

import AEntidades.Artista;
import CServicos.ArtistaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtistaController {
    private ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    public void cadastrarArtista() {
        Scanner sc = new Scanner(System.in);
        try {
            String id = String.valueOf(0);

            System.out.println("Digite o Nome do Artista: ");
            String nome = sc.nextLine();

            System.out.println("Digite o Gênero Musical: ");
            String generoMusical = sc.nextLine();

            artistaService.cadastrarArtista(id, nome, generoMusical);
            System.out.println("Artista cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarArtistas() {
        for (Artista artista : artistaService.listar()) {
            System.out.println(artista);
        }
    }

    public void excluirArtistaPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do artista a ser excluído: ");
        String id = sc.nextLine();
        artistaService.excluirPorId(id);
    }

    public void atualizarArtistaPorNome() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do artista a ser atualizado: ");
        String nome = sc.nextLine();

        System.out.println("Digite o novo nome do artista: ");
        String novoNome = sc.nextLine();

        System.out.println("Digite o novo gênero musical: ");
        String novoGenero = sc.nextLine();

        Artista novoArtista = new Artista("", novoNome, novoGenero, new ArrayList<>());
        artistaService.atualizarPorNome(nome, novoArtista);
        System.out.println("Artista atualizado com sucesso!");
    }

}
