package project.mohak.booking.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/bookings/{bookingId}/paymentStatus")
    public boolean getPaymentStatus() {
        // todo : get payment status
        return false;
    }

    @PostMapping("/bookings/{bookingId}/update")
    public boolean confirmBooking() {
        // todo : confirm/fail payment
        return true;
    }
}
