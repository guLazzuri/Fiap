package entities;

import java.lang.reflect.Array;
import java.util.List;

public class Artist {
    private int id;
    private String name;
    private String genre;
    private String ListMusic ;

    public Artist( String name, String genre, String listMusic) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.ListMusic = listMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getListMusic() {
        return ListMusic;
    }

    public void setListMusic(String listMusic) {
        ListMusic = listMusic;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", ListMusic='" + ListMusic + '\'' +
                '}';
    }
}