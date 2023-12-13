package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uct.domain.Driver;
import za.ac.uct.domain.Rental;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {
}
