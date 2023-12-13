package za.ac.uct.controllers;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.settings.Settings;
import za.ac.uct.service.SettingsService;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping("/read")
    public Settings getSettings() {
        return settingsService.read(1);
    }

}
