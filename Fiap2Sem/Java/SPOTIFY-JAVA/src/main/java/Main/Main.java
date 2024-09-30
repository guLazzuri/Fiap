package Main;

import Repositories.ArtistRepositories;
import entities.Artist;

public class Main {
    public static void main(String[] args) {

        var artistRpositories = new ArtistRepositories();

        //var produto = new Produto(0, "Sprite", 5.5);
        //produtoRespositorio.Insert(produto);

        //artistRpositories.GetAll();
        //produtos.forEach(System.out::println);

        //System.out.println(artistRpositories.GetById(5));
        // System.out.println(produto);

//        artists = artistRpositories.GetByName("Spr");
//        artists.forEach(System.out::println);
        //artistRpositories.Delete(2);
//
//        artistRpositories.Insert(new Artist("Gustavo", "pop"));
        artistRpositories.Delete(2);
        System.out.println(artistRpositories.GetById(2));

    }
}