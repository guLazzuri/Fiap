package org.example.entities;

import java.util.List;

public class Album extends _BaseEntity {
    private String title;
    private Artist artist;
    private List<Music> musics;

    public Album() {
    }

    public Album(String title, Artist artist, List<Music> musics) {
        this.title = title;
        this.artist = artist;
        this.musics = musics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", musics=" + musics +
                "} " + super.toString();
    }
}
