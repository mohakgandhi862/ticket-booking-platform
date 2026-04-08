package project.mohak.booking.platform.service;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import project.mohak.booking.platform.model.Movie;
import project.mohak.booking.platform.model.Screen;
import project.mohak.booking.platform.model.Show;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class ShowService {

    private final List<Show> shows = new ArrayList<>();

    public List<Show> getAllShows() {
        return shows;
    }

    public Show getShow(String sId) {
        for (Show s : shows) {
            if (s.getId().equalsIgnoreCase(sId)) {
                return s;
            }
        }

        return null;
    }

    public String createShow(@NonNull String showId, @NonNull Movie movie,
                             @NonNull Screen screen, @NonNull Date date,
                             @NonNull Integer durationInSeconds) {
        Show show = new Show(showId, movie, screen, date, durationInSeconds);
        shows.add(show);
        return showId;
    }

    public boolean checkIfShowExistsById(@NonNull String showId) {
        for (Show s : shows) {
            if (s.getId().equalsIgnoreCase(showId)) {
                return true;
            }
        }

        return false;
    }

    public List<Show> searchShows(String mName, Date date) {
        return shows.stream().filter(show -> show.getMovie().getName().toLowerCase().contains(mName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
