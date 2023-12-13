package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.Rental;

import java.util.List;
import java.util.Optional;

/**
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 * RentalRepository.java
 */
@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {


    Optional<Rental> findAllByEventId(int id);
    Optional<Rental> findTopByEventIdOrderByReturnedDateDesc(int id);

    List<Rental> findByUserIdAndReturnedDateIsNull(int id);


}

