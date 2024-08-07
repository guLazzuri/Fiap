package bgg;

public class Rating {
    private String username;
    private int rating;
    private String comment;

    public Rating() {
    }

    public Rating(String username, int rating, String comment) {
        this.username = username;
        if(rating < 0 || rating > 10)
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        else
            this.rating = rating;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating < 0 || rating > 10)
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
