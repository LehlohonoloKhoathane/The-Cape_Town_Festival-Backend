package za.ac.uct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.uct.domain.HelpCenter;
import za.ac.uct.service.impl.IHelpCenterServiceImpl;

import java.util.ArrayList;

/**
 * HelpCenterController.java
 * This is the controller for the Help Center entity
 * Author: Lehlohonolo Khoathane
 * Date: 22/11/2023
 */

@RestController
@RequestMapping("/api/help-center")
public class HelpCenterController {
    @Autowired
    private IHelpCenterServiceImpl helpCenterService;

    @GetMapping("/get-all")
    public ArrayList<HelpCenter> getAll() {
        ArrayList<HelpCenter> helpCenterList = new ArrayList<>(helpCenterService.getAll());
        return helpCenterList;
    }

    @GetMapping("/get-all-by-category/{category}")
    public ArrayList<HelpCenter> getAllByCategory(@PathVariable String category) {
        return helpCenterService.getAllByCategory(category);
    }
}
