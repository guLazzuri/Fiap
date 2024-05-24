package mtgtop8;

public class Player {
    private String name;
    private String country;
    private String nickname;

    public Player() {
    }

    public Player(String name, String country, String nickname) {
        this.name = name;
        this.country = country;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
