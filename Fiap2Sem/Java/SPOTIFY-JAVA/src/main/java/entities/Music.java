package entities;

public class Music {
    private int id;
    private int duration;
    private String name;
    private String year;

    public Music(int id, String name, String year, String duration) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameMusic) {
        this.name = nameMusic;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", duration=" + duration +
                ", nameMusic='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
