package mtgtop8;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private String name;
    private MTG_FORMAT format;
    private LocalDateTime dateEvent;
    private List<TournamentPlayer> players;
    private int rating;
    private String location;

    public Event() {
    }

    public Event(String name, MTG_FORMAT format, LocalDateTime dateEvent, List<TournamentPlayer> players, int rating, String location) {
        this.name = name;
        this.format = format;
        this.dateEvent = dateEvent;
        this.players = players;
        this.rating = rating;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MTG_FORMAT getFormat() {
        return format;
    }

    public void setFormat(MTG_FORMAT format) {
        this.format = format;
    }

    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    public List<TournamentPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<TournamentPlayer> players) {
        this.players = players;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", format=" + format +
                ", dateEvent=" + dateEvent +
                ", players=" + players +
                ", rating=" + rating +
                ", location='" + location + '\'' +
                '}';
    }
}
