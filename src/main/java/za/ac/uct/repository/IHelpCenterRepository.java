package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uct.domain.HelpCenter;

import java.util.ArrayList;

/**
 * IHelpCenterRepository.java
 * Interface for the IHelpCenterRepository
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

@Repository
public interface IHelpCenterRepository extends JpaRepository<HelpCenter, Integer> {
    public ArrayList<HelpCenter> findAllByCategory(String category);
}