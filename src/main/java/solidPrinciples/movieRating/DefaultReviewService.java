package solidPrinciples.movieRating;

import java.util.HashMap;
import java.util.Map;

public class DefaultReviewService implements ReviewService {
    private final Map<String, Review> reviews = new HashMap<>();

    @Override
    public void addReview(String userId, String movieId, String reviewText) {
        String reviewKey = userId + "-" + movieId;
        Review review = new Review(userId, movieId, reviewText);
        reviews.put(reviewKey, review);
    }

    @Override
    public Review getReview(String userId, String movieId) {
        String reviewKey = userId + "-" + movieId;
        return reviews.get(reviewKey);
    }

    @Override
    public void updateReview(String userId, String movieId, String reviewText) {
        String reviewKey = userId + "-" + movieId;
        Review review = reviews.get(reviewKey);
        if (review != null) {
            review.setReviewText(reviewText);
        }
    }

    /*
    @Override
    public void updateReview(String userId, String movieId, String reviewText) {
        String reviewKey = userId + "-" + movieId;
        Review review = new Review(userId, movieId, reviewText);
        if (reviews.containsKey(reviewKey)) {
            reviews.put(reviewKey, review);
        }
    }

     */
    @Override
    public void deleteReview(String userId, String movieId) {
        String reviewKey = userId + "-" + movieId;
        reviews.remove(reviewKey);
    }
}
