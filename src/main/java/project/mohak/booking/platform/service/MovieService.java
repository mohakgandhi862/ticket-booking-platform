package project.mohak.booking.platform.service;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import project.mohak.booking.platform.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(String id) {
        for (Movie movie : movies) {
            if (movie.getId().equalsIgnoreCase(id)) {
                return movie;
            }
        }

        return null;
    }

    public String createMovie(@NonNull String id, @NonNull String name) {
        movies.add(new Movie(id, name));
        return id;
    }

    public boolean checkIfMovieExistsById(@NonNull String movieId) {
        for (Movie movie : movies) {
            if (movie.getId().equalsIgnoreCase(movieId)) {
                return true;
            }
        }

        return false;
    }
}
