package za.ac.uct.repository;
/**
 * EventRepository.java
 * Interface for the EventRepository
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Integer> {


    List<Event> findByPriceGroupAndRentalsReturnedDateIsNotNull(PriceGroup priceGroup);

    //List<Event> findAvailableEvents();
    ///is event by id available
    boolean existsByIdAndIsAvailableIsTrue(int id);

    //set event isavailable to false
    // void setEventToNotAvailable(int id);
//    Event setIsAvailableToFalse(int id);
    //set event isavailable to true
//    Event setIsAvailableToTrue(int id);
    //set event isavailable to false
   // boolean isEventByIdAndIsAvailableIsTrue(int id);

    @Modifying
    @Query("UPDATE Event c SET c.isAvailable = false WHERE c.id = :id")
    void setIsAvailableToFalse(@Param("id") int id);

    //set event isavailable to true
    @Modifying
    @Query("UPDATE Event c SET c.isAvailable = true WHERE c.id = :id")
    void setIsAvailableToTrue(@Param("id") int id);

}