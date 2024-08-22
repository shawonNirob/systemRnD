package solidPrinciples.movieRating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultMovieService implements MovieService {
    private final Map<String, Movie> movies = new HashMap<>();

    @Override
    public void addMovie(Movie movie){
        movies.put(movie.getId(), movie);
    }

    @Override
    public Movie findMovieById(String movieId) {
        return movies.get(movieId);
    }

    @Override
    public void updateMovie(Movie movie){
        movies.put(movie.getId(), movie);
    }

    @Override
    public void deleteMovie(String movieId) {
        movies.remove(movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies.values().stream().collect(Collectors.toList());
    }
}
