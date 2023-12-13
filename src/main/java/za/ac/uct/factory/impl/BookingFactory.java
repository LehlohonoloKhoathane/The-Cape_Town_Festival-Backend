package za.ac.uct.factory.impl;

import za.ac.uct.domain.Booking;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.security.User;

import java.time.LocalDateTime;

public class BookingFactory {

    public static Booking createBooking(int id, User user, Event event, LocalDateTime bookingDate, LocalDateTime returnedDate) {
        return new Booking.Builder()
                .id(id)
                .user(user)
                .event(event)
                .bookingDate(bookingDate)
                .returnedDate(returnedDate)
                .build();
    }
}
