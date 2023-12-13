package za.ac.uct.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Event.java
 * Entity for the Event
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */


@Entity

public class Event {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "event") //one event to many RSVPs
    private List<Rental> RSVPs = new ArrayList<>();
    private String make;
    private String model;
    private int year;
    private String category;
    @Enumerated(EnumType.STRING)
    private PriceGroup priceGroup;
    private String licensePlate;
    private boolean isAvailable;

    public Event() {
        // Default constructor
    }

    private Event(Builder builder) {
        this.id = builder.id;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.category = builder.category;
        this.priceGroup = builder.priceGroup;
        this.licensePlate = builder.licensePlate;
        this.isAvailable = builder.isAvailable;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public PriceGroup getPriceGroup() {
        return priceGroup;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPriceGroup(PriceGroup priceGroupEnum) {
        this.priceGroup = priceGroupEnum;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId() && getYear() == event.getYear() && Objects.equals(getMake(), event.getMake()) && Objects.equals(getModel(), event.getModel()) && Objects.equals(getCategory(), event.getCategory()) && Objects.equals(getLicensePlate(), event.getLicensePlate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getYear(), getCategory(), getLicensePlate());
    }


    public String getPriceGroupString() {
        return priceGroup != null ? priceGroup.toString() : "NONE";
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", category='" + category + '\'' +
                ", priceGroup=" + priceGroup +
                ", isAvailable=" + isAvailable +
                '}';
    }


    public static class Builder {
        private int id;
        private String make;
        private String model;
        private int year;
        private String category;

        private PriceGroup priceGroup;

        private String licensePlate;
        private boolean isAvailable;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder make(String make) {
            this.make = make;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder priceGroup(PriceGroup priceGroup) {
            this.priceGroup = priceGroup;
            return this;
        }

        public Builder licensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;

        }

        public Builder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Builder copy(Event event) {
            this.id = event.id;
            this.make = event.make;
            this.model = event.model;
            this.year = event.year;
            this.category = event.category;
            this.priceGroup = event.priceGroup;
            this.licensePlate = event.licensePlate;
            this.isAvailable = event.isAvailable;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}