package solidPrinciples.movieRating;

public class Movie {
    private String id;
    private String title;

    public Movie(String id, String title) {
        this.id = id;
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(String id) {
        this.id = id;
    }
}
