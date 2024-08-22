package solidPrinciples.movieRating;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie);
    Movie findMovieById(String movieId);
    void updateMovie(Movie movie);
    void deleteMovie(String movieId);
    List<Movie> getAllMovies();
}
