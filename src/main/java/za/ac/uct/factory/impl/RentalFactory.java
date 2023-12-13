package za.ac.uct.factory.impl;

import org.springframework.stereotype.Component;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.Rental;
/*import za.ac.uct.domain.User;*/
import za.ac.uct.factory.IFactory;
import za.ac.uct.domain.security.User;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/ 2023
 * RSVPFactory Class.java
 */
@Component
public class RentalFactory implements IFactory<Rental> {
    public Rental create(int id, User user, Event event, int issuer, int receiver, int fine, LocalDateTime issuedDate, LocalDateTime returnedDate) {

        return new Rental.Builder()
                .setId(id)
                .setUser(user)
                .setEvent(event)
                .setIssuer(issuer)
                .setReceiver(receiver)
                .setFine(fine)
                .setIssuedDate(issuedDate)
                .setDateReturned(returnedDate)
                .build();
    }
    public Rental create() {
        return new Rental.Builder()
                .setId(new Random().nextInt(1000000))
                .build();
    }

    public Rental create(Rental RSVP) {
        return new Rental.Builder()
                .copy(RSVP)
                .build();
    }
}


