package za.ac.uct.repository;
/**
 * IDamageReportRepository.java
 * Repository Interface for the Damage Report
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uct.domain.DamageReport;
@Repository
public interface IDamageReportRepository extends JpaRepository<DamageReport, Integer> {

}
