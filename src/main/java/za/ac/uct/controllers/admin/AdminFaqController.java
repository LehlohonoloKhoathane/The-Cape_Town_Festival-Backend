package za.ac.uct.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.Faq;
import za.ac.uct.service.impl.IFaqServiceImpl;

import java.util.ArrayList;

/**
 * AdminFaqController.java
 * This is the controller for the Admin Faq entity
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

@RestController
@RequestMapping("/api/admin/faq")
public class AdminFaqController {
    @Autowired
    private IFaqServiceImpl faqService;

    @PostMapping("/create")
    public Faq createFaq(@RequestBody Faq faq) {
        return faqService.create(faq);
    }

    @GetMapping("/read/{id}")
    public Faq readFaq(@PathVariable int id) {
        return faqService.read(id);
    }

    @PostMapping("/update")
    public Faq updateFaq(@RequestBody Faq faq) {
        return faqService.update(faq);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return faqService.delete(id);
    }

    @GetMapping("/get-all")
    public ArrayList<Faq> getAll() {
        ArrayList<Faq> allFaq = new ArrayList<>(faqService.getAll());
        return allFaq;
    }
}
