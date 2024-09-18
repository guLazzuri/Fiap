package Main;

import Repositories.ArtistRepositories;
import entities.Artist;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fazendo insert no oracle");

        var artistRpositories = new ArtistRepositories();

        //var produto = new Produto(0, "Sprite", 5.5);
        //produtoRespositorio.Insert(produto);

        var artists = artistRpositories.GetAll();
        //produtos.forEach(System.out::println);

        var artist = artistRpositories.GetById(1);
        // System.out.println(produto);

        artists = artistRpositories.GetByName("Spr");
        artists.forEach(System.out::println);
        artistRpositories.Delete(42);

        artistRpositories.Insert(new Artist(1, "Coca-Cola 500ml", "pop","gustavo"));
    }
}