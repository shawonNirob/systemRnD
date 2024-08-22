package solidPrinciples.movieRating;

public interface RatingService {
    void rateMovie(String userId, String movieId, int rating);
    double getAverageRating(String movieId);
    void updateRating(String userId, String movieId, int rating);
    void deleteRating(String userId, String movieId);
}
