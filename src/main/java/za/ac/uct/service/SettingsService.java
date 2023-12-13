package za.ac.uct.service;
/**
 *
 * Author: Peter Buckingham (220165289)
 *
 */

import za.ac.uct.domain.settings.Settings;

public interface SettingsService {

        Settings create(Settings settings);

        Settings read(Integer id);

        Settings update(Settings settings);

        boolean delete(Integer id);

        Iterable<Settings> getAll();
}
