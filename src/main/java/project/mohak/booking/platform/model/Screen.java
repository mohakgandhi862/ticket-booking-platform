package project.mohak.booking.platform.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
    private final String id;
    private final String name;
    private final Movie movie;
    private final String theatreId;
    private final List<Seat> seats;

    public Screen(@NonNull final String id, @NonNull final String name,
                  @NonNull final Movie movie, String theatreId) {
        this.id = id;
        this.name = name;
        this.movie = movie;
        this.theatreId = theatreId;
        seats = new ArrayList<>();
    }

    public void addSeat(@NonNull final Seat seat) {
        seats.add(seat);
    }

}
