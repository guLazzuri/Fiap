package org.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import AEntidades.Artista;
import AEntidades.Musica;
import Repositorio.AlbumRepositorio;
import Repositorio.ArtistaRepositorio;
import Repositorio.MusicaRepositorio;
import CServicos.AlbumService;
import CServicos.ArtistaService;
import CServicos.MusicaService;
import Controller.AlbumController;
import Controller.ArtistaController;
import Controller.MusicaController;
import Utils.Database.DatabaseConfig;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Criação da conexão com o banco de dados
        try (Connection connection = DatabaseConfig.getConnection()) {
            // Inicializando os repositórios
            AlbumRepositorio albumRepositorio = new AlbumRepositorio(connection);
            ArtistaRepositorio artistaRepositorio = new ArtistaRepositorio(connection);
            MusicaRepositorio musicaRepositorio = new MusicaRepositorio(connection);

            // Inicializando os serviços
            AlbumService albumService = new AlbumService(albumRepositorio);
            ArtistaService artistaService = new ArtistaService(artistaRepositorio);
            MusicaService musicaService = new MusicaService(musicaRepositorio);

            // Inicializando os controladores
            AlbumController albumController = new AlbumController(albumService);
            ArtistaController artistaController = new ArtistaController(artistaService);
            MusicaController musicaController = new MusicaController(musicaService);

            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Gerenciar Álbuns.");
                System.out.println("2. Gerenciar Artistas.");
                System.out.println("3. Gerenciar Músicas.");
                System.out.println("0. Sair");

                int opcao = sc.nextInt();
                sc.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        gerenciarAlbuns(sc, albumController, albumService);
                        break;
                    case 2:
                        gerenciarArtistas(sc, artistaController, artistaService);
                        break;
                    case 3:
                        gerenciarMusicas(sc, musicaController, musicaService);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void gerenciarAlbuns(Scanner sc, AlbumController albumController, AlbumService albumService) {
        System.out.println("Escolha uma ação para Álbum:");
        System.out.println("1. Cadastrar álbum");
        System.out.println("2. Listar álbuns");
        System.out.println("3. Atualizar álbum");
        System.out.println("4. Remover álbum");
        System.out.println("5. Buscar álbum por ano");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                albumController.cadastrarAlbum();
                break;
            case 2:
                albumController.listarAlbum();
                break;
            case 3:
                albumController.atualizarAlbumPorNome();
                break;
            case 4:
                albumController.excluirAlbumPorId();
                break;
            case 5:
                System.out.println("Digite o ano do álbum:");
                int ano = sc.nextInt();
                albumService.buscarPorAno(ano).forEach(System.out::println);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void gerenciarArtistas(Scanner sc, ArtistaController artistaController, ArtistaService artistaService) {
        System.out.println("Escolha uma ação para Artista:");
        System.out.println("1. Cadastrar artista");
        System.out.println("2. Listar artistas");
        System.out.println("3. Atualizar artista");
        System.out.println("4. Remover artista");
        System.out.println("5. Buscar artista por gênero musical");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                artistaController.cadastrarArtista();
                break;
            case 2:
                List<Artista> artistas = artistaService.listar();
                artistas.forEach(System.out::println);
                break;
            case 3:
                artistaController.atualizarArtistaPorNome();
                break;
            case 4:
                artistaController.excluirArtistaPorId();
                break;
            case 5:
                System.out.println("Digite o gênero musical:");
                String genero = sc.nextLine();
                List<Artista> artistasEncontrados = artistaService.buscarPorGenero(genero);
                artistasEncontrados.forEach(System.out::println);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void gerenciarMusicas(Scanner sc, MusicaController musicaController, MusicaService musicaService) {
        System.out.println("Escolha uma ação para Música:");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar músicas");
        System.out.println("3. Atualizar música");
        System.out.println("4. Remover música");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                musicaController.cadastrarMusica();
                break;
            case 2:
                List<Musica> musicas = musicaService.listar();
                musicas.forEach(System.out::println);
                break;
            case 3:
                musicaController.atualizarMusicaPorNome();
                break;
            case 4:
                musicaController.excluirMusicaPorId();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
