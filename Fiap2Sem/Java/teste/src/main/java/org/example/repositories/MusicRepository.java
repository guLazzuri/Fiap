package org.example.repositories;

import org.example.entities.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository extends _BaseRepositoryImpl<Music> {
    private List<Music> musics = new ArrayList<>();
    public MusicRepository() {
        super(Music.class);
    }

    public MusicRepository(List<Music> musics) {
        super(Music.class);
        this.musics = musics;
    }

    public List<Music> getAll() {
        logger.logReadAll(null);
        return musics;
    }

    public void add(Music music) {
        logger.logCreate(music);
        musics.add(music);
    }
}
