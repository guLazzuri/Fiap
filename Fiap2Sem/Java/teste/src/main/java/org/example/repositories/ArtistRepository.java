package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.example.Main;
import org.example.entities.Artist;
import org.example.utils.Log4jLogger;
import org.example.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository extends _BaseRepositoryImpl<Artist> {
    private Log4jLogger logger = new Log4jLogger(Artist.class);
    private List<Artist> artists = new ArrayList<>();


    public ArtistRepository() {
        super(Artist.class);
    }

    public ArtistRepository(List<Artist> artists) {
        super(Artist.class);
        this.artists = artists;
    }

    public List<Artist> getAll() {
        logger.logReadAll(null);
        return artists;
    }

    public void add(Artist artist) {
        logger.logCreate(artist);
        artists.add(artist);
    }
}
