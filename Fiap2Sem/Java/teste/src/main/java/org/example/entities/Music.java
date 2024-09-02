package org.example.entities;

public class Music extends _BaseEntity {
    private String title;
    private Album album;

    public Music() {
    }

    public Music(int id, String title, Album album) {
        super(id);
        this.title = title;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", album=" + album +
                "} " + super.toString();
    }
}
