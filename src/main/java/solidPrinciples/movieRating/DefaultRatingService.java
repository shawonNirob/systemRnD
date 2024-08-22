package solidPrinciples.movieRating;

import java.util.HashMap;
import java.util.Map;

public class DefaultRatingService implements RatingService {
    private final Map<String, Rating> ratings = new HashMap<>();
    private final Map<String, Integer> ratingCount = new HashMap<>();
    private final Map<String, Integer> ratingSum = new HashMap<>();

    @Override
    public void rateMovie(String userId, String movieId, int rating) {
        String ratingKey = movieId + "-" + userId;
        Rating newRating = new Rating(userId, movieId, rating);
        ratings.put(ratingKey, newRating);

        ratingCount.put(movieId, ratingCount.getOrDefault(movieId, 0) + 1);
        ratingSum.put(movieId, ratingSum.getOrDefault(movieId, 0) + rating);
    }

    @Override
    public double getAverageRating(String movieId) {
        int count = ratingCount.getOrDefault(movieId, 0);
        int sum = ratingSum.getOrDefault(movieId, 0);

        return count == 0 ? 0 : (double) sum / count;
    }

    @Override
    public void updateRating(String userId, String movieId, int rating) {
        String ratingKey = movieId + "-" + userId;
        Rating existingRating = ratings.get(ratingKey);
        if (existingRating != null) {
            int oldRating = existingRating.getRating();
            existingRating.setRating(rating);
            ratingSum.put(movieId, ratingSum.get(movieId) - oldRating + rating);
        }
    }

    @Override
    public void deleteRating(String userId, String movieId) {
        String ratingKey = movieId + "-" + userId;
        Rating exixtingRating = ratings.remove(ratingKey);
        if (exixtingRating != null) {
            int rating = exixtingRating.getRating();
            ratingCount.put(movieId, ratingCount.get(movieId) - 1);
            ratingSum.put(movieId, ratingSum.get(movieId) - rating);
        }
    }
}
