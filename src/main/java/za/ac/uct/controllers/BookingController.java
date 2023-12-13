package za.ac.uct.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.Booking;
import za.ac.uct.domain.Event; // Make sure you import the Event class
import za.ac.uct.domain.security.User;
import za.ac.uct.security.JwtUtilities;
import za.ac.uct.service.IEventService;
import za.ac.uct.service.IUserService;
import za.ac.uct.service.impl.BookingServiceImpl;
import za.ac.uct.service.IEventService;
import java.util.List;

@RestController
@RequestMapping("/api/admin/bookings")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private IEventService IeventService;

    // Include the jwtUtilities and userService dependencies
    @Autowired
    private JwtUtilities jwtUtilities;
    @Autowired
    private IUserService iUserService;

    @PostMapping("/admin/create")
    public Booking createBooking(@RequestBody Booking booking, HttpServletRequest request) {
        // Check if the user is authenticated with a valid token
        String token = jwtUtilities.getToken(request);
        if (token != null && jwtUtilities.validateToken(token)) {
            String userEmail = jwtUtilities.extractUsername(token);

            // Get the user by email and associate it with the booking
            User user = iUserService.read(Integer.valueOf(userEmail));
            if (user != null) {
                booking.setUser(user);
                // Implement your logic to create a booking here using bookingService
                // return bookingService.create(booking);
                return booking;
            } else {
                // Handle the case where the user doesn't exist
                return null;
            }
        } else {
            // Handle the case where the token is invalid or not present
            // You might want to return an error response or throw an exception
            return null; // Modify this to suit your needs
        }
    }
    @GetMapping("/events/all")
    public List<Event> getAllEvents() {
        List<Event> events = IeventService.getAll();
        return events;
    }

    @GetMapping("/profile")
    public User getUserProfile(HttpServletRequest request) {
        // Include the jwtUtilities and userService logic here
        String token = jwtUtilities.getToken(request);

        if (token != null && jwtUtilities.validateToken(token)) {
            String userEmail = jwtUtilities.extractUsername(token);

            return iUserService.read(Integer.valueOf(userEmail));
        } else {
            // Handle the case where the token is invalid or not present
            // You might want to return an error response or throw an exception
            return null; // Modify this to suit your needs
        }
    }

    @PutMapping("/update/{bookingId}")
    public Booking updateBooking(@PathVariable Integer bookingId, @RequestBody Booking booking) {
        // Implement your logic to update a booking here using bookingService
        // return bookingService.updateById(bookingId, booking);
        return booking;
    }
}
