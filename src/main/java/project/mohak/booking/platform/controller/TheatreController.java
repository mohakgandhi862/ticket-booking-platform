package project.mohak.booking.platform.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mohak.booking.platform.exception.InvalidInputException;
import project.mohak.booking.platform.model.Screen;
import project.mohak.booking.platform.model.Theatre;
import project.mohak.booking.platform.service.MovieService;
import project.mohak.booking.platform.service.TheatreService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatre(@PathVariable final String id) {
        if (!theatreService.checkIfTheatreExistsById(id))
            throw new InvalidInputException("Invalid Input theatre Id : " + id);

        return theatreService.getTheatre(id);
    }

    @PostMapping
    public String createTheatre(@NonNull final String id, @NonNull final String name, @NonNull final String city) {
        return theatreService.createTheatre(id, name, city);
    }

    @GetMapping("/{TheatreId}/screens")
    public List<Screen> getAllScreensInTheatre(@PathVariable String theatreId) {
        if (!theatreService.checkIfTheatreExistsById(theatreId))
            throw new InvalidInputException("Invalid Input theatre Id : " + theatreId);

        return theatreService.getTheatre(theatreId).getScreens();
    }

    @PostMapping("/{theatreId}/screens")
    public String createScreenInTheatre(@NonNull String screenId, @NonNull final String screenName,
                                        @NonNull final String movieId, @PathVariable final String theatreId) {

        boolean isMovieIdValid = movieService.checkIfMovieExistsById(movieId);
        boolean isTheatreIdValid = theatreService.checkIfTheatreExistsById(theatreId);
        if (!isTheatreIdValid || !isMovieIdValid) {
            throw new InvalidInputException("Invalid Input movieId : " + movieId + ", theatreId : " + theatreId);
        }

        return theatreService.createScreenInTheatre(screenId, screenName, movieId, theatreId);
    }

    @PostMapping("/{theatreId}/screens/{screenId}/seats")
    public String createSeatInScreen(@PathVariable String theatreId, @PathVariable String screenId,
                                     @NonNull String seatId, @NonNull String rowNumber, @NonNull String seatNumber) {

        boolean isTheatreIdValid = theatreService.checkIfTheatreExistsById(theatreId);
        boolean isScreenIdValid = theatreService.checkIfScreenExistsById(screenId);
        if(!isTheatreIdValid || !isScreenIdValid)
            throw new InvalidInputException("Invalid Input theatre Id : " + theatreId + ", screenId : " + screenId);

        return theatreService.createSeatInScreen(seatId ,rowNumber, seatNumber, screenId);
    }
}
