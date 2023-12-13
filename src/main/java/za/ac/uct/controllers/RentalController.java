package za.ac.uct.controllers;

/**
 * AdminRentalController.java
 * This is the controller for the RSVP entity
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.uct.domain.Rental;
import za.ac.uct.service.impl.RentalServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user/RSVPs")
public class RentalController {
    @Autowired
    private RentalServiceImpl rentalService;

    /*   @GetMapping("/list/all")
    public ArrayList<Rental> getAll() {
        ArrayList<Rental> RSVPs = new ArrayList<>(rentalService.getAll());
        return RSVPs;
    }*/

    @PostMapping("/create")
    public Rental createRental(@RequestBody Rental RSVP) {
        // Retrieve user and event based on their IDs
    /*    System.out.println(RSVP.getUser());
        System.out.println(RSVP.getEvent());
        System.out.println(RSVP.getIssuedDate());
        System.out.println(RSVP.getReturnedDate());*/

        //user + event + times == RSVP
            //User
                //1 receive the token - header
                //2 find the user by their email from the token (extract the email from the token)//jwtutils
                //3 find user via repository and return user object

            //Event
                //4 find the event by its id - event service -> event repo = event object

            //Rental
                //5 create a RSVP object with the user, event and times

       /* return rentalService.create(RSVP);*/

        System.out.println("/api/user/RSVPs/create was triggered");
      //  System.out.println("RentalService was created...attempting to create RSVP...");

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


}
