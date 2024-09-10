package Menu;

import Entidades.Album;
import Entidades.Artista;
import Repositorio.AlbumRepositorio;
import Repositorio.ArtistaRepositorio;
import Repositorio.MusicaRepositorio;

import java.util.List;
import java.util.Scanner;

public class Menu {
    ArtistaRepositorio artistaRep = new ArtistaRepositorio();
    AlbumRepositorio albumRep = new AlbumRepositorio();
    MusicaRepositorio musicaRep = new MusicaRepositorio();
    Scanner sc = new Scanner(System.in);

    public void mostrarMenu() throws Exception {
        int opcaoMenu;
        do {
            System.out.println("Menu");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Artista ");
            System.out.println("2. Cadastrar Album ");
            System.out.println("3. Cadastrar Musica ");
            System.out.println("4. Listar Artista ");
            System.out.println("5. Pesquisar Artista por Genero ");
            System.out.println("6. Pesquisar Album por Ano ");

            System.out.println("Escolha uma opção: ");
            opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu){
                case 1:
                    System.out.println("Cadastrar Artista");
                    artistaRep.cadastrarArtista();
                    break;
                case 2:
                    System.out.println("Cadastrar album");
                    albumRep.cadastrarAlbum();
                    break;
                case 3:
                    System.out.println("Cadastrar Musica");
                    musicaRep.cadastrarMusica();
                    break;
                case 4:
                    System.out.println("Listando Artistas: ");
                    System.out.println(artistaRep.listar()); //adicionei na lista obterTodos
                    break;
                case 5:
                    System.out.println("Digite o genero musical, que deseja pesquisar: ");
                    String genero = sc.nextLine();
                    List<Artista> listaGenero = artistaRep.pesquisarPorGenero(genero);
                    if (listaGenero.isEmpty()){
                        System.out.println("Nenhum artista encontrado no genero: " +genero);
                    }else{
                        System.out.println("Artistas encontrados no genero"+genero);
                        for (Artista artista : listaGenero){
                            System.out.println(artista.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o ano do album que deseja pesquisar: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    List<Album> albunsEncontrados = albumRep.pesquisarPorAno(ano);
                    if (albunsEncontrados.isEmpty()){
                        System.out.println("Nenhum album encontrado para o ano" + ano);
                    }else {
                        System.out.println("Albuns encontrados: ");
                        for (Album album : albunsEncontrados){
                            System.out.println(album);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Opção invalida. ");
                    break;
            }
        }while (opcaoMenu != 0);

        sc.close();
    }
}
