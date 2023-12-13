package za.ac.uct.service.impl;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.uct.domain.Event;
import za.ac.uct.factory.impl.EventFactory;
import za.ac.uct.repository.EventRepository;
import za.ac.uct.service.IEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("eventServiceImpl")
public class EventServiceImpl implements IEventService {

    @Autowired
    private EventRepository repository;
    @Autowired
    private EventFactory eventFactory;


    public EventServiceImpl(EventRepository repository) {

        this.repository = repository;
    }

    @Override
    public Event create(Event event) {
        event.setAvailable(true);
        Event newEvent = eventFactory.create(event);
        return repository.save(newEvent);

    }

    @Override
    public Event read(Integer id) {
        //optional
        Optional<Event> optionalEvent = this.repository.findById(id);
        return optionalEvent.orElse(null);
    }

    @Override
    public Event update(Event event) {
        if (this.repository.existsById((int) event.getId())) {
            Event updatedEvent = eventFactory.create(event);
            return this.repository.save(updatedEvent);
        }
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
    public ArrayList<Event> getAll() {

        ArrayList<Event> all = (ArrayList<Event>) this.repository.findAll();
        return all;


    }

    //get all available events
    public ArrayList<Event> getAllAvailableEvents() {
        List<Event> availableEvents = new ArrayList<>();
        List<Event> events = getAll();
        for (Event event : events) {
            if (event.isAvailable()) {
                availableEvents.add(event);
            }
        }
        return (ArrayList<Event>) availableEvents;
    }

    //check if event is available
    public boolean isEventAvailable(Event event) {
        return event.isAvailable();
    }



}
