package project.mohak.booking.platform.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class Seat {
    private final String id;
    private final String rowNumber;
    private final String seatNumber;

    @Setter
    private BookingStatus status;

    public Seat(@NonNull String id, @NonNull String rowNumber, @NonNull String seatNumber) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.status = BookingStatus.CREATED;
    }
}
