package mtgtop8;

public class TournamentPlayer {
    private Player player;
    private Deck deck;
    private int place;

    public TournamentPlayer() {
    }

    public TournamentPlayer(Player player, Deck deck, int place) {
        this.player = player;
        this.deck = deck;
        this.place = place;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "TournamentPlayer{" +
                "player=" + player +
                ", deck=" + deck +
                ", place=" + place +
                '}';
    }
}
