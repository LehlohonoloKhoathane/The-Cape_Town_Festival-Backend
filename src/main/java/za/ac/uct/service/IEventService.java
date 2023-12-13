package za.ac.uct.service;
/**
 *
 * Author: Peter Buckingham (220165289)
 *
 */
import za.ac.uct.domain.Event;

import java.util.ArrayList;

public interface IEventService extends IService<Event, Integer> {
    Event create(Event event);

    Event read(Integer id);

    Event update(Event event);

    boolean delete(Integer id);

    ArrayList<Event> getAll();
}
