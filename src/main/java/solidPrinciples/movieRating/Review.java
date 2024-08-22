package solidPrinciples.movieRating;

public class Review {
    private String userId;
    private String movieId;
    private String reviewText;

    public Review(String userId, String movieId, String reviewText) {
        this.userId = userId;
        this.movieId = movieId;
        this.reviewText = reviewText;
    }

    public String getUserId() {
        return userId;
    }
    public String getMovieId() {
        return movieId;
    }
    public String getReviewText() {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
