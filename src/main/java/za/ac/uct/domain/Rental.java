package za.ac.uct.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import za.ac.uct.domain.security.User;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/ 2023
 * RSVP Class.java
 */


@Entity
public class Rental implements Serializable {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne //many RSVPs to one user
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne //many RSVPs to one event
    @JoinColumn(name = "event_id")
    private Event event;
    //driver
    @ManyToOne //many RSVPs to one driver
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private int issuer;
    private int receiver;
    private int fine;
    private LocalDateTime issuedDate;
    private LocalDateTime returnedDate;

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setIssuer(int issuer) {
        this.issuer = issuer;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void setIssuedDate(LocalDateTime issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    //Initializing a parameterized constructor
    public Rental(int id, User user, Event event, int issuer, int receiver, int fine, LocalDateTime issuedDate, LocalDateTime returnedDate) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.issuer = issuer;
        this.issuedDate = issuedDate;
        this.returnedDate = returnedDate;
        this.receiver = receiver;
        this.fine = fine;
    }

    private Rental(Builder builder) {

        this.id = builder.id;
        this.user = builder.user;
        this.event = builder.event;
        this.receiver = builder.receiver;
        this.issuer = builder.issuer;
        this.issuedDate = builder.issuedDate;
        this.returnedDate = builder.returnedDate;
        this.fine = builder.fine;

    }

    public Rental() {

    }

    //Builder Class
    public static Builder builder() {
        return new Builder();
    }

    public int getRentalId() {
        return this.id;
    }
    public int getId() {
        return id;
    }

    public int getFine() {
        return fine;
    }

    public int getIssuer() {
        return issuer;
    }

    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }


    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public int getReceiver() {
        return receiver;
    }


    public boolean finePaid() {
        return false;
    }

    @Override
    public String toString() {
        return "RSVP{" +
                "rentalId=" + id +
                ", issuer='" + issuer + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", dateReturned='" + returnedDate + '\'' +
                ", receiver='" + receiver + '\'' +
                ", finePaid=" + fine +
                '}';
    }

    public User getUser() {
        return this.user;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static class Builder {

        private int id;
        private User user;
        private Event event;
        private int issuer;
        private int receiver;
        private int fine;

        private LocalDateTime issuedDate;
        private LocalDateTime returnedDate;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }


        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setEvent(Event event) {
            this.event = event;
            return this;
        }

        public Builder setIssuer(int issuer) {
            this.issuer = issuer;
            return this;
        }


        public Builder setIssuedDate(LocalDateTime issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }

        public Builder setDateReturned(LocalDateTime returnedDate) {
            this.returnedDate = returnedDate;
            return this;
        }

        public Builder setReceiver(int receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder setFine(int fine) {
            this.fine = fine;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }

        public Builder copy(Rental RSVP) {
            this.id = RSVP.id;
            this.user = RSVP.user;
            this.event = RSVP.event;
            this.issuer = RSVP.issuer;
            this.issuedDate = RSVP.issuedDate;
            this.returnedDate = RSVP.returnedDate;
            this.receiver = RSVP.receiver;
            this.fine = RSVP.fine;
            return this;
        }
    }
}
