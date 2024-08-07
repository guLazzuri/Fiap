package bgg;

import java.util.List;

public abstract class Game {
    private String name;
    private int yearLaunched;
    private int minPlayers;
    private int maxPlayers;
    private int bestNumPlayers;
    private int meanPlayTime;
    private int minAge;
    private double meanRatings;
    private List<Rating> ratings;

    public Game() {
    }

    public Game(String name, int yearLaunched, int minPlayers, int maxPlayers,
                int bestNumPlayers, int meanPlayTime, int minAge,
                List<Rating> ratings) {
        this.name = name;
        this.yearLaunched = yearLaunched;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.bestNumPlayers = bestNumPlayers;
        this.meanPlayTime = meanPlayTime;
        this.minAge = minAge;
        this.ratings = ratings;
        this.meanRatings = calculateMeanRatings();
    }

    private double calculateMeanRatings() {
        return ratings.stream()
                .mapToDouble(Rating::getRating)
                .average()
                .orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearLaunched() {
        return yearLaunched;
    }

    public void setYearLaunched(int yearLaunched) {
        this.yearLaunched = yearLaunched;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getBestNumPlayers() {
        return bestNumPlayers;
    }

    public void setBestNumPlayers(int bestNumPlayers) {
        this.bestNumPlayers = bestNumPlayers;
    }

    public int getMeanPlayTime() {
        return meanPlayTime;
    }

    public void setMeanPlayTime(int meanPlayTime) {
        this.meanPlayTime = meanPlayTime;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public double getMeanRatings() {
        return meanRatings;
    }

    public void setMeanRatings(double meanRatings) {
        this.meanRatings = meanRatings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", yearLaunched=" + yearLaunched +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                ", bestNumPlayers=" + bestNumPlayers +
                ", meanPlayTime=" + meanPlayTime +
                ", minAge=" + minAge +
                ", meanRatings=" + meanRatings +
                ", ratings=" + ratings +
                '}';
    }
}
