package za.ac.uct.service.impl;
/**
 * Author: Peter Buckingham (220165289)
 */

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;
import za.ac.uct.domain.Rental;
/*import za.ac.uct.domain.User;*/
import za.ac.uct.exception.EventNotAvailableException;
import za.ac.uct.exception.UserCantRentMoreThanOneEventException;
import za.ac.uct.factory.impl.RentalFactory;
import za.ac.uct.repository.EventRepository;
import za.ac.uct.repository.RentalRepository;
import za.ac.uct.domain.security.User;
import za.ac.uct.service.IRentalService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("rentalServiceImpl")
public class RentalServiceImpl implements IRentalService {
    @Autowired
    private RentalRepository repository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RentalFactory rentalFactory;
    private Event event;

    //is event available
    public boolean isEventAvailable(Rental RSVP) {
        Event eventToRent = RSVP.getEvent();
        return eventRepository.existsByIdAndIsAvailableIsTrue((int) eventToRent.getId());
    }

    public boolean isEventAvailableByEventId(Event event) {
        this.event = event;
        return eventRepository.existsByIdAndIsAvailableIsTrue((int) event.getId());
    }
    @Override
    @Transactional
    public Rental create(Rental RSVP) {
        if (isEventAvailable(RSVP)) {
            if (isCurrentlyRenting(RSVP.getUser())) {
                throw new UserCantRentMoreThanOneEventException(
                        generateUserRentingErrorMessage(RSVP.getUser()));
            }
            Rental newRental = rentalFactory.create(RSVP);
            if (newRental.getReturnedDate() != null) {
                eventRepository.setIsAvailableToTrue((int) newRental.getEvent().getId());
                System.out.println("Is event available after update: " + newRental.getEvent().isAvailable());
            }else {
                eventRepository.setIsAvailableToFalse((int) newRental.getEvent().getId());
                System.out.println("Is event available after update: " + newRental.getEvent().isAvailable());
            }
           // eventRepository.setIsAvailableToFalse((int) newRental.getEvent().getId());
            return repository.save(newRental);
        } else {
            throw new EventNotAvailableException(generateEventNotAvailableErrorMessage(RSVP.getEvent()));
        }
    }

    @Override
    public Rental read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Rental update(Rental RSVP) {
        System.out.println("RentalServiceImpl.update : ");
        System.out.println("RSVP Id received : " + RSVP.getRentalId());

        if (repository.existsById(RSVP.getRentalId())) {

            System.out.println("Rental " + RSVP.getRentalId() + " found");
            System.out.println(RSVP);
            Rental updatedRental = rentalFactory.create(RSVP);
            // Set event to available if the RSVP was returned
            if (updatedRental.getReturnedDate() != null) {
                Event event = updatedRental.getEvent();
                event.setAvailable(true);
                eventRepository.save(event); // Save the updated event entity
                System.out.println("Is event available after update: " + event.isAvailable());
            }else {
                Event event = updatedRental.getEvent();
                event.setAvailable(false);
                eventRepository.save(event); // Save the updated event entity
                System.out.println("Is event available after update: " + event.isAvailable());
            }

            return repository.save(updatedRental);
        }
        System.out.println("Rental " + RSVP.getRentalId() + " not found");
        return null;
    }
    @Transactional
    public Rental update(int Id, Rental RSVP) {
        System.out.println("RentalServiceImpl.update : ");
        System.out.println("RSVP Id received : " + RSVP.getRentalId());

        if (repository.existsById(RSVP.getRentalId())) {

            System.out.println("Rental " + RSVP.getRentalId() + " found");
            System.out.println(RSVP);
            Rental updatedRental = rentalFactory.create(RSVP);
            // Set event to available if the RSVP was returned
            if (updatedRental.getReturnedDate() != null) {
                Event event = updatedRental.getEvent();
                event.setAvailable(true);
                eventRepository.save(event); // Save the updated event entity
                System.out.println("Is event available after update: " + event.isAvailable());
            }else {
                Event event = updatedRental.getEvent();
                event.setAvailable(false);
                eventRepository.save(event); // Save the updated event entity
                System.out.println("Is event available after update: " + event.isAvailable());
            }

            return repository.save(updatedRental);
        }
        System.out.println("Rental " + RSVP.getRentalId() + " not found");
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Rental> getAll() {
        return (ArrayList<Rental>) this.repository.findAll();
    }

    //get all available events
    // needs to be implemented
    public ArrayList<Rental> getAllAvailableEvents() {
        List<Rental> allRentals = repository.findAll();
        //filter all RSVPs to only include available events
        return filterAvailableEvents(allRentals);
    }

    private ArrayList<Rental> filterAvailableEvents(List<Rental> RSVPs) {
        ArrayList<Rental> availableEvents = new ArrayList<>();
        for (Rental RSVP : RSVPs) {
            if (isEventAvailable(RSVP)) {
                availableEvents.add(RSVP);
            }
        }
        return availableEvents;
    }

    private String generateEventNotAvailableErrorMessage(Event event) {
        return event.getMake() + " " + event.getModel() + " " +
                event.getLicensePlate() + " is not available for RSVP at this time";
    }

    private String generateUserRentingErrorMessage(User user) {
        Rental currentRental = getCurrentRental(user);
        Event rentedEvent = currentRental.getEvent();
        return user.getFirstName() + " " + user.getLastName() + " is currently renting " +
                rentedEvent.getMake() + " " + rentedEvent.getModel() + " " +
                rentedEvent.getLicensePlate();
    }

    //refactored isEventAvailable
//    private boolean isEventAvailable(Rental RSVP) {
//        Event eventToRent = RSVP.getEvent();
//        Optional<Rental> rentalFromDatabaseOptional = findMostRecentRentalByEventId(eventToRent.getId());
//        Rental rentalFromDatabase = rentalFromDatabaseOptional.orElse(null);
//        printRentalInfo(rentalFromDatabase, RSVP.getReturnedDate());
//        return isEventAvailableBasedOnRental(RSVP);
//    }

    private Optional<Rental> findMostRecentRentalByEventId(Long eventId) {
        return repository.findTopByEventIdOrderByReturnedDateDesc(Math.toIntExact(eventId));
    }

    private void printRentalInfo(Rental rentalFromDatabase, LocalDateTime returnedDate) {
        if (returnedDate != null) {
            LocalDateTime timeSinceLastRental = returnedDate.minusDays(rentalFromDatabase.getReturnedDate().getDayOfMonth());
            System.out.println("Rental Date - rentalFromDatabase: " + timeSinceLastRental);
        } else {
            System.out.println("The event has not been returned yet");
            LocalDateTime timeSinceLastRental = LocalDateTime.now().minusDays(rentalFromDatabase.getIssuedDate().getDayOfMonth());
            System.out.println("Rental Date - rentalFromDatabase: " + rentalFromDatabase.getIssuedDate().getDayOfMonth());
        }
    }


    //refactored isEventAvailableByEventId
//    public boolean isEventAvailableByEventId(Event event) {
//        Optional<Rental> rentalByEventIdOrderByReturnedDateDesc = findMostRecentRentalByEventId(event.getId());
//
//        if (rentalByEventIdOrderByReturnedDateDesc.isPresent()) {
//            Rental rentalFromDatabase = rentalByEventIdOrderByReturnedDateDesc.get();
//
//            if (rentalFromDatabase.getReturnedDate() != null) {
//                printRentalInfoForEventAvailability(rentalFromDatabase, "Event is available");
//                // If the most recent RSVP is returned 24 hours before the new RSVP, then the event is available
//                return isEventAvailableBasedOnRental(rentalFromDatabase);
//            } else {
//                printRentalInfoForEventAvailability(rentalFromDatabase, "Event is not available");
//            }
//        }
//
//        return false;
//    }

    /// refactored
    private void printRentalInfoForEventAvailability(Rental rentalFromDatabase, String availabilityMessage) {

        if (rentalFromDatabase.getReturnedDate() != null) {
            // Calculate time since returned
            Duration timeSinceReturned = Duration.between(rentalFromDatabase.getReturnedDate(), LocalDateTime.now());

            // Check if over 24 hours
            if (timeSinceReturned.toHours() >= 24) {
                System.out.println("Over 24 hours since event was returned");
            } else {
                System.out.println("Under 24 hours since event was returned");
            }

        } else {
            System.out.println("The event has not been returned yet");
        }
        System.out.println(availabilityMessage);
    }

   /* private boolean isEventAvailableBasedOnRental(Rental rentalFromDatabase) {
        return rentalFromDatabase.getReturnedDate().plusDays(1).isBefore(LocalDateTime.now());
    }*/

    //refactored

    private boolean isEventAvailableBasedOnRental(Rental rentalFromDatabase) {

        // Handle null RSVP
        if (rentalFromDatabase == null) {
            return true;
        }

        // Handle null return date
        if (rentalFromDatabase.getReturnedDate() == null) {
            System.out.println("Rental has not been returned yet");
            return false;
        }

        // Calculate RSVP duration
        // Check if over 24 hours
        // Calculate RSVP duration
        LocalDateTime rentalReturned = rentalFromDatabase.getReturnedDate();
        LocalDateTime now = LocalDateTime.now();

        Duration rentalDuration = Duration.between(rentalReturned, now);

        return rentalDuration.toHours() >= 24;

    }


    public boolean isCurrentlyRenting(User user) {
        // Find active RSVPs for the user
        List<Rental> activeRentals = repository.findByUserIdAndReturnedDateIsNull(user.getId());

        // If the user has any active RSVPs, they are currently renting a event
        return !activeRentals.isEmpty();
    }

    public Rental getCurrentRental(User user) {
        // Find active RSVPs for the user
        List<Rental> activeRentals = repository.findByUserIdAndReturnedDateIsNull(user.getId());

        // If the user has any active RSVPs, they are currently renting a event
        if (!activeRentals.isEmpty()) {
            return activeRentals.get(0);
        }
        return null;
    }

    //TODO: This is to be used to replace filtering currently done in the controller layer
    public List<Event> getAvailableEventsByPrice(PriceGroup priceGroup) {
        // Join to RSVPs table and check availability
        // check if event is available
        ArrayList<Event> availableEvents = new ArrayList<>(eventRepository.findByPriceGroupAndRentalsReturnedDateIsNotNull(priceGroup));
        for (Event event : availableEvents)   //for each event in available events
        {
            if (!isEventAvailableByEventId(event)) //if event is not available
            {
                availableEvents.remove(event); //remove event from available events
            }
        }
        return availableEvents;


    }
    @Override //testing
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}







