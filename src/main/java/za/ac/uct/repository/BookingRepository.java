package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.uct.domain.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserId(int userId);
}

