package za.ac.uct.domain;

import jakarta.persistence.*;
import za.ac.uct.domain.security.User;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private LocalDateTime bookingDate;
    private LocalDateTime returnedDate;

    // Constructors

    public Booking() {
    }

    public Booking(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.event = builder.event;
        this.driver = builder.driver;
        this.bookingDate = builder.bookingDate;
        this.returnedDate = builder.returnedDate;
    }

    // Getters

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", driver=" + driver +
                ", bookingDate=" + bookingDate +
                ", returnedDate=" + returnedDate +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private User user;
        private Event event;
        private Driver driver;
        private LocalDateTime bookingDate;
        private LocalDateTime returnedDate;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder event(Event event) {
            this.event = event;
            return this;
        }

        public Builder driver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder bookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder returnedDate(LocalDateTime returnedDate) {
            this.returnedDate = returnedDate;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }

        public Builder copy(Booking booking) {
            this.id = booking.id;
            this.user = booking.user;
            this.event = booking.event;
            this.driver = booking.driver;
            this.bookingDate = booking.bookingDate;
            this.returnedDate = booking.returnedDate;
            return this;
        }
    }
}
