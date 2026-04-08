package project.mohak.booking.platform.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mohak.booking.platform.model.Booking;
import project.mohak.booking.platform.model.Show;
import project.mohak.booking.platform.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    private final List<Booking> bookings = new ArrayList<>();

    public String createBooking(@NonNull String bookingId, @NonNull String showId,
                                @NonNull String uId, @NonNull List<String> seats) {
        Show show = showService.getShow(showId);
        User user = userService.getUser(uId);
        bookings.add(new Booking(bookingId, show, seats, user));
        // todo : redirect user to payment, check for payment status
        return bookingId;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking getBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getId().equalsIgnoreCase(bookingId)) {
                return booking;
            }
        }

        return null;
    }

    public boolean checkIfBookingExistsById(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getId().equalsIgnoreCase(bookingId)) {
                return true;
            }
        }

        return false;
    }
}
