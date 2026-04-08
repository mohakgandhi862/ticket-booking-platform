package project.mohak.booking.platform.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mohak.booking.platform.model.Movie;
import project.mohak.booking.platform.model.Screen;
import project.mohak.booking.platform.model.Seat;
import project.mohak.booking.platform.model.Theatre;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private MovieService movieService;

    private List<Theatre> theatres = new ArrayList<>();
    private List<Screen> screens = new ArrayList<>();

    public String createTheatre(String id, String name, String city) {
        theatres.add(new Theatre(id, name, city));
        return id;
    }

    public String createScreenInTheatre(@NonNull String screenId, @NonNull String screenName,
                                        @NonNull String movieId, @NonNull String theatreId) {
        Movie movie = movieService.getMovieById(movieId);
        Theatre theatre = getTheatre(theatreId);
        Screen screen = new Screen(screenId, screenName, movie, theatreId);
        theatre.addScreen(screen);
        screens.add(screen);
        return screenId;
    }

    public String createSeatInScreen(@NonNull String id, @NonNull String rowNumber,
                                     @NonNull String seatNumber, @NonNull String screenId) {
        Screen screen = getScreen(screenId);
        screen.addSeat(new Seat(id, rowNumber, seatNumber));
        return id;
    }

    public Theatre getTheatre(String id) {
        for(Theatre t : theatres) {
            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }

        return null;
    }

    public List<Theatre> getAllTheatres() {
        return theatres;
    }

    public Screen getScreen(String id) {
        for(Screen s : screens) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

    public boolean checkIfTheatreExistsById(String theatreId) {
        for (Theatre theatre : theatres) {
            if (theatre.getId().equalsIgnoreCase(theatreId)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfScreenExistsById(String screenId) {
        for (Screen screen : screens) {
            if (screen.getId().equalsIgnoreCase(screenId)) {
                return true;
            }
        }

        return false;
    }
}
