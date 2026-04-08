package project.mohak.booking.platform.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mohak.booking.platform.exception.InvalidInputException;
import project.mohak.booking.platform.model.Booking;
import project.mohak.booking.platform.model.User;
import project.mohak.booking.platform.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable String bookingId) {
        if (!bookingService.checkIfBookingExistsById(bookingId)) {
            throw new InvalidInputException("Invalid Booking id : " + bookingId);
        }
        return bookingService.getBooking(bookingId);
    }

    @PostMapping
    public String createBooking(@NonNull String bookingId, @NonNull String showId,
                                @NonNull String uId, @NonNull List<String> seats) {
        System.out.println("Booking created with id = " + bookingId +
                ", showId = " + showId + ", UserId = " + uId);
        return bookingService.createBooking(bookingId, showId, uId, seats);
    }
}
