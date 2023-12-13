package za.ac.uct.repository;
/**
 * Author: Lehlohonolo Khoathane
 * Date: 23/11/2023
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.uct.domain.ContactUs;

import java.util.Optional;

public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {
    //Optional<Object> findById();
}
