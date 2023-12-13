package za.ac.uct.repository;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.uct.domain.settings.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Integer> {
}
