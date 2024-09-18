package entities;

import java.lang.reflect.Array;
import java.util.List;

public class Artist {
    private int id;
    private String name;
    private String genre;
    private List<Music> ListMusic ;

    public Artist() {
    }

    public Artist(int id, String name, String genre, List<Music> listMusic) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        ListMusic = listMusic;
    }

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Artist(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public List<Music> getListMusic() {
        return ListMusic;
    }

    public void setListMusic(List<Music> listMusic) {
        ListMusic = listMusic;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", ListMusic=" + ListMusic +
                '}';
    }
}
