package project.mohak.booking.platform.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mohak.booking.platform.exception.InvalidInputException;
import project.mohak.booking.platform.model.Movie;
import project.mohak.booking.platform.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable final String id) {
        if (!movieService.checkIfMovieExistsById(id))
            throw new InvalidInputException("Invalid Movie id : " + id);

        return movieService.getMovieById(id);
    }

    @PostMapping
    public String createMovie(@NonNull final String id, @NonNull final String name) {
        System.out.println("Movie created with id = " + id + ", name = " + name);
        movieService.createMovie(id, name);
        return name;
    }
}
