package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Artist;
import org.example.entities.Music;
import org.example.repositories.ArtistRepository;
import org.example.repositories.MusicRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MusicRepository musicRepository = new MusicRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist = new Artist(1, "Artist 1", new ArrayList<>());
        Music music = new Music(1, "Music 1", null);
        musicRepository.add(music);
        System.out.println(musicRepository.getAll());
        artistRepository.add(artist);
        System.out.println(artistRepository.getAll());


    }
}