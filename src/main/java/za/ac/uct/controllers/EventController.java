package za.ac.uct.controllers;
/**
 * EventController.java
 * This is the controller for the Event class
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;
import za.ac.uct.service.impl.EventServiceImpl;
import za.ac.uct.service.impl.RentalServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RestController


//set url
/*@CrossOrigin(origins = "http://localhost:5173")*/
public class EventController {

    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private RentalServiceImpl rentalService;


    @GetMapping("/api/events/list/all")
    public List<Event> getEvents() {
        List<Event> allEvents = new ArrayList<>(eventService.getAll());
        return allEvents;
    }

    @GetMapping("/api/events/list/economy")
    public List<Event> getEconomyEvents() {
        List<Event> economyEvents = new ArrayList<>(eventService.getAll());
        economyEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.ECONOMY);
        return economyEvents;
    }

    @GetMapping("/api/events/list/luxury")
    public List<Event> getLuxuryEvents() {
        List<Event> luxuryEvents = new ArrayList<>(eventService.getAll());
        luxuryEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.LUXURY);
        return luxuryEvents;
    }

    @GetMapping("/api/events/list/special")
    public List<Event> getSpecialEvents() {
        List<Event> specialEvents = new ArrayList<>(eventService.getAll());
        specialEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.SPECIAL);
        return specialEvents;
    }
    @GetMapping("/api/events/list/available/all")
    public List<Event> getAllAvailableEvents() {
        List<Event> allEvents = new ArrayList<>(eventService.getAll());
        allEvents.removeIf(event -> !rentalService.isEventAvailableByEventId(event));
        return allEvents;
    }

    @GetMapping("/api/events/list/available/economy")
    public List<Event> getAvailableEconomyEvents() {
        List<Event> economyEvents = new ArrayList<>(eventService.getAll());
        economyEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.ECONOMY || !rentalService.isEventAvailableByEventId(event));
        return economyEvents;
    }

  /*  @GetMapping("/api/events/list/available/luxury")
    public List<Event> getAvailableLuxuryEvents() {
        List<Event> luxuryEvents = new ArrayList<>(eventService.getAll());
        luxuryEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.LUXURY || !rentalService.isEventAvailableByEventId(event));
        return luxuryEvents;
    }
*/

    // TODO: migrate to this method for all the filtering, using the service to filter the list
    @GetMapping("/api/events/list/available/luxury")
    public List<Event> getAvailableLuxuryEvents() {
        // Fetch already filtered list from service
        List<Event> availableEvents = rentalService.getAvailableEventsByPrice(PriceGroup.LUXURY);
        return availableEvents;
    }


    @GetMapping("/api/events/list/available/special")
    public List<Event> getAvailableSpecialEvents() {
        List<Event> specialEvents = new ArrayList<>(eventService.getAll());
        specialEvents.removeIf(event -> event.getPriceGroup() != PriceGroup.SPECIAL || !rentalService.isEventAvailableByEventId(event));
        return specialEvents;
    }

    @GetMapping("/api/events/read/{eventId}")
    public Event readEvent(@PathVariable Integer eventId) {
        System.out.println("/api/events/read was triggered");
        System.out.println("EventService was created...attempting to read event...");
        Event readEvent = eventService.read(eventId);
        return readEvent;
    }


}
