package za.ac.uct.controllers.admin;

/**
 * AdminRentalController.java
 * This is the controller for the RSVP entity
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.Rental;
import za.ac.uct.factory.impl.RentalFactory;
import za.ac.uct.service.impl.RentalServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/RSVPs")
public class AdminRentalController {
    @Autowired
    private RentalServiceImpl rentalService;

    @GetMapping("/list/all")
    public ArrayList<Rental> getAll() {
        ArrayList<Rental> RSVPs = new ArrayList<>(rentalService.getAll());
        return RSVPs;
    }

    @PostMapping("/create")
    public Rental createRental(@RequestBody Rental RSVP) {
        System.out.println("/api/admin/RSVPs/create was triggered");
        System.out.println("RentalService was created...attempting to create RSVP...");

        // Retrieve user and event based on their IDs
        System.out.println(RSVP.getUser());
        System.out.println(RSVP.getEvent());
        System.out.println(RSVP.getIssuedDate());
        System.out.println(RSVP.getReturnedDate());
        return rentalService.create(RSVP);
    }

    @GetMapping("/read/{rentalId}")
    public Rental readRental(@PathVariable Integer rentalId) {
        System.out.println("/api/admin/RSVPs/read was triggered");
        System.out.println("RentalService was created...attempting to read RSVP...");
        Rental readRental = rentalService.read(rentalId);
        return readRental;
    }

    @PutMapping("/update/{rentalId}")
            public Rental updateRental(@PathVariable Integer rentalId, @RequestBody Rental RSVP) {
            Rental rentalToUpdate = rentalService.read(rentalId);
            Rental rentalRequest = RSVP;
            Rental updatedRental =Rental.builder()
                    .setId(rentalToUpdate.getId())
                    .setUser(rentalToUpdate.getUser())
                    .setEvent(rentalToUpdate.getEvent())
                    .setIssuer(rentalRequest.getIssuer())
                    .setReceiver(rentalRequest.getReceiver())
                    .setFine(rentalRequest.getFine())
                    .setIssuedDate(rentalRequest.getIssuedDate())
                    .setDateReturned(rentalRequest.getReturnedDate())
                    .build();

                System.out.println("RSVP to update: " + rentalToUpdate);


        System.out.println("/api/admin/RSVPs/update was triggered");
        System.out.println("");
        System.out.println("form front end : " + RSVP.toString());
        System.out.println("");
        System.out.println("RSVP Id: " + RSVP.getId());
        System.out.println("RSVP user: " + RSVP.getUser());
        System.out.println("RSVP event: " + RSVP.getEvent());
        System.out.println("issued by: " + RSVP.getIssuer());
        System.out.println("RSVP issued date: " + RSVP.getIssuedDate());
        System.out.println(" " + RSVP.getReturnedDate());
        Rental updated = rentalService.update(rentalId,updatedRental);
        System.out.println("updated RSVP: " + updated);
        return updated;
    }
    @DeleteMapping("/delete/{rentalId}")
    public boolean deleteRental(@PathVariable Integer rentalId) {
        System.out.println("/api/admin/RSVPs/delete was triggered");
        System.out.println("RentalService was created...attempting to delete RSVP...");
        return rentalService.delete(rentalId);
    }
}
