package t04.basis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieDB implements Serializable {
    private List<Movie> movies;

    public MovieDB() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addActor(int movieNumber, Actor actor) {
        movies.get(movieNumber).addActor(actor);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }
}
