package project.mohak.booking.platform.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Booking {
    private final String id;
    private final Show show;
    private final List<String> seatsBooked;
    private final User user;
    private BookingStatus status;
}
