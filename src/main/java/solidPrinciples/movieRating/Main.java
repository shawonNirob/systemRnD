package solidPrinciples.movieRating;

import solidPrinciples.emailLogin.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //User related service
        UserRepository userRepository = new InMemoryUserRepository();
        PasswordHasher passwordHasher = new PasswordHasher();
        UserService userService = new DefaultUserService(userRepository, passwordHasher);

        //Movie-related service
        MovieService movieService = new DefaultMovieService();
        RatingService ratingService = new DefaultRatingService();
        ReviewService reviewService = new DefaultReviewService();

        //Registar user
        userService.registerUser("Nirob1@gmail.com", "password");
        userService.registerUser("Nirob2@gmail.com", "password1");
        userService.registerUser("Nirob3@gmail.com", "password2");

        //Add movie
        Movie movie1 = new Movie("1", "The matrix");
        movieService.addMovie(movie1);
        Movie movie2 = new Movie("2", "The Punisher");
        movieService.addMovie(movie2);
        Movie movie3 = new Movie("3", "Intersteller");
        movieService.addMovie(movie3);



        //Previous rating
        ratingService.rateMovie("Nirob1@gmail.com", "1", 5);
        reviewService.addReview("Nirob1@gmail.com", "1", "This is a amazing movie!");
        ratingService.rateMovie("Nirob2@gmail.com", "1", 3);
        reviewService.addReview("Nirob2@gmail.com", "1", "amazing movie!");
        ratingService.rateMovie("Nirob3@gmail.com", "2", 4);
        reviewService.addReview("Nirob3@gmail.com", "2", "Perfect movie!");


        boolean loginSuccesssful = userService.loginUser("Nirob3@gmail.com", "password2");
        if (loginSuccesssful) {

            ratingService.rateMovie("Nirob1@gmail.com", "1", 5);
            reviewService.addReview("Nirob1@gmail.com", "1", "Good to see it");

            Movie movieNew = movieService.findMovieById("1");
            double averageRating = ratingService.getAverageRating("1");
            System.out.println("The rating of the movie "+ movieNew.getTitle() +"is "+ averageRating);

            Review review  = reviewService.getReview("Nirob1@gmail.com", "1");
            System.out.println("The review is: " + review.getReviewText());

            //update movie
            movie1.setTitle("The Matrix Reloader");
            movieService.updateMovie(movie1);

            ratingService.updateRating("Nirob1@gmail.com", "1", 2);

            reviewService.updateReview("Nirob1@gmail.com", "1", "Bad movie");

            //display
            System.out.println("The update rating is: " + ratingService.getAverageRating("1"));
            System.out.println("The update review is: " + reviewService.getReview("Nirob1@gmail.com", "1").getReviewText());


            //delete
            movieService.deleteMovie("1");
            reviewService.deleteReview("Nirob1@gmail.com", "1");
            ratingService.deleteRating("Nirob1@gmail.com", "1");

            //Show the existing movie
            List<Movie> movies = movieService.getAllMovies();
            for (Movie movie : movies) {
                System.out.println("Movie: " + movie.getTitle());
            }
        }
    }
}
