package za.ac.uct.service;

import za.ac.uct.domain.Booking;
import java.util.List;

public interface BookingService {
    Booking create(Booking booking);
    Booking read(int bookingId);
    Booking updateById(int bookingId, Booking updatedBooking);
    boolean delete(int bookingId);
    List<Booking> getAll();
    Booking getBookingById(int bookingId);
    Booking update(Booking booking);

}
