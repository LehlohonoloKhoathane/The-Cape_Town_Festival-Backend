package za.ac.uct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.uct.domain.Faq;
import za.ac.uct.service.impl.IFaqServiceImpl;

import java.util.ArrayList;

/**
 * FaqController.java
 * This is the controller for the Faq entity
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

@RestController
@RequestMapping("/api/faq")
public class FaqController {
    @Autowired
    private IFaqServiceImpl faqService;

    @GetMapping("/get-all")
    public ArrayList<Faq> getAll() {
        ArrayList<Faq> allFaq = new ArrayList<>(faqService.getAll());
        return allFaq;
    }
}
