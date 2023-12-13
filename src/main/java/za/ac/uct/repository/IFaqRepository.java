package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uct.domain.Faq;

/**
 * IFaqRepository.java
 * Interface for the IFaqRepository
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

@Repository
public interface IFaqRepository extends JpaRepository<Faq, Integer> {
}
