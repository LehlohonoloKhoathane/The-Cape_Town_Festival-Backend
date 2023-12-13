package za.ac.uct.controllers.admin;
/**
 * AdminEventController.java
 * This is the controller for the Events entity
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;
import za.ac.uct.service.impl.EventServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/events")
public class AdminEventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/all")
    public List<Event> getEvents() {
        List<Event> allEvents = new ArrayList<>(eventService.getAll());
        return allEvents;
    }
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        System.out.println("/api/admin/events/create was triggered");
        event.setPriceGroup(mapPriceGroup(event.getPriceGroupString()));
        System.out.println("PriceGroup was set to: " + event.getPriceGroup());
        System.out.println("EventService was created...attempting to create event...");
        Event createdEvent = eventService.create(event);
        return createdEvent;
    }

    @GetMapping("/read/{eventId}")
    public Event readEvent(@PathVariable Integer eventId) {
        System.out.println("/api/admin/events/read was triggered");
        System.out.println("EventService was created...attempting to read event...");
        Event readEvent = eventService.read(eventId);
        return readEvent;
    }

    @PutMapping("/update/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event updatedEvent) {
        Event updated = eventService.update(updatedEvent);
        return updated;
    }

    @DeleteMapping("/delete/{eventId}")
    public boolean deleteEvent(@PathVariable Integer eventId) {
        System.out.println("/api/admin/events/delete was triggered");
        System.out.println("EventService was created...attempting to delete event...");
        return eventService.delete(eventId);
    }

    private PriceGroup mapPriceGroup(String priceGroupString) {
        try {
            return PriceGroup.valueOf(priceGroupString);
        } catch (IllegalArgumentException e) {
            return PriceGroup.NONE;
        }
    }

}
//.delete(`http://localhost:8080/api/admin/events/delete/${eventId}`)