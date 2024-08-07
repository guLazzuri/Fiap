package bgg;

import java.util.ArrayList;
import java.util.List;

public class Boardgame extends Game{

    public Boardgame(String name, int yearLaunched, int minPlayers, int maxPlayers,
                int bestNumPlayers, int meanPlayTime, int minAge,
                List<Rating> ratings) {
        super(name, yearLaunched, minPlayers, maxPlayers,
                bestNumPlayers, meanPlayTime, minAge, ratings);
    }

    @Override
    public String toString() {
        return "Boardgame{} " + super.toString();
    }
}
