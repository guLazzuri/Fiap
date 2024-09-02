package org.example.entities;

import java.util.List;

public class Artist extends _BaseEntity {
    private String name;
    private List<Album> albums;

    public Artist() {
    }

    public Artist(int id, String name, List<Album> albums) {
        super(id);
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", albums=" + albums +
                "} " + super.toString();
    }
}
