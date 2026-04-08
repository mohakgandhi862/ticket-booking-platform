package project.mohak.booking.platform.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mohak.booking.platform.exception.InvalidInputException;
import project.mohak.booking.platform.model.Movie;
import project.mohak.booking.platform.model.Screen;
import project.mohak.booking.platform.model.Show;
import project.mohak.booking.platform.service.MovieService;
import project.mohak.booking.platform.service.ShowService;
import project.mohak.booking.platform.service.TheatreService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/theatre/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @Autowired
    MovieService movieService;

    @Autowired
    TheatreService theatreService;

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{showId}")
    public Show getShow(@PathVariable String showId) {
        if (!showService.checkIfShowExistsById(showId))
            throw new InvalidInputException("Invalid Show Id : " + showId);

        return showService.getShow(showId);
    }

    @PostMapping
    public String createShow(@NonNull final String showId, @NonNull final String movieId,
                             @NonNull final String screenId, @NonNull final Date startTime,
                             @NonNull final Integer durationInSeconds) {
        Movie movie = movieService.getMovieById(movieId);
        Screen screen = theatreService.getScreen(screenId);
        return showService.createShow(showId, movie, screen, startTime, durationInSeconds);
    }

    @GetMapping("/search")
    public List<Show> searchMovies(@RequestParam String movieName, @RequestParam Date date) {
        return showService.searchShows(movieName, date);
    }
}
