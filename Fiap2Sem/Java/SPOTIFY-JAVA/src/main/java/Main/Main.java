package Main;

import Repositories.ArtistRepositories;
import entities.Artist;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var artistRepositories = new ArtistRepositories();

//        // Inserindo novos artistas
//        artistRepositories.Insert(new Artist("Gustavo", "Pop"));
//        artistRepositories.Insert(new Artist("Anitta", "Funk"));
//        artistRepositories.Insert(new Artist("Caetano Veloso", "MPB"));

//        // Obtendo todos os artistas
//        List<Artist> artists = artistRepositories.GetAll();
//        System.out.println("Lista de artistas:");
//        artists.forEach(System.out::println);

//        // Buscando um artista pelo ID
//        System.out.println("\nArtista com ID 2:");
//        System.out.println(artistRepositories.GetById(2).orElse(null));
//
//        // Atualizando um artista
//        artistRepositories.Update(new Artist("Gustavo Lima", "Sertanejo"), 1);
//
//        // Removendo um artista
//        artistRepositories.Delete(2);
//        System.out.println("\nApós remover o artista com ID 2:");
//        artists = artistRepositories.GetAll();
//        artists.forEach(System.out::println);
    }
}
