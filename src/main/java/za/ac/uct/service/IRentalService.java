package za.ac.uct.service;
/**
 *
 * Author: Peter Buckingham (220165289)
 *
 */
import za.ac.uct.domain.Rental;

import java.util.ArrayList;

public interface IRentalService extends IService<Rental, Integer> {
    Rental create(Rental RSVP);

    Rental read(Integer id);

    Rental update(Rental RSVP);

    boolean delete(Integer id);

    ArrayList<Rental> getAll();

    boolean existsById(Integer id);


}
