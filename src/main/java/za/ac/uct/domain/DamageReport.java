package za.ac.uct.domain;

/**DamageReport.java
 * Domain Class for the Damage Report
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 * */
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
@Entity
public class DamageReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "RSVP", referencedColumnName = "id", unique = true)
    private Rental RSVP;
    private String description;
    private LocalDateTime dateAndTime;
    private String location;
    private double repairCost;


    public DamageReport() {
    }

    public DamageReport(Builder builder) {
        this.id = builder.id;
        this.RSVP = builder.RSVP;
        this.description = builder.description;
        this.dateAndTime = builder.dateAndTime;
        this.location = builder.location;
        this.repairCost = builder.repairCost;
    }

    public int getId() {
        return id;
    }

    public Rental getRental() {
        return RSVP;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public String getLocation() {
        return location;
    }

    public double getRepairCost() {
        return repairCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DamageReport that = (DamageReport) o;
        return id == that.id && Double.compare(that.repairCost, repairCost) == 0 && Objects.equals(RSVP, that.RSVP) && Objects.equals(description, that.description) && Objects.equals(dateAndTime, that.dateAndTime) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, RSVP, description, dateAndTime, location, repairCost);
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "id=" + id +
                ", RSVP=" + RSVP +
                ", description='" + description + '\'' +
                ", dateAndTime=" + dateAndTime +
                ", location='" + location + '\'' +
                ", repairCost=" + repairCost +
                '}';
    }

    public static class Builder {
        private int id;
        private Rental RSVP;
        private String description;
        private LocalDateTime dateAndTime;
        private String location;
        private double repairCost;

        public Builder setId(int id) {
            this.id = id;
            return  this;
        }

        public Builder setRental(Rental RSVP) {
            this.RSVP = RSVP;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDateAndTime(LocalDateTime dateAndTime) {
            this.dateAndTime = dateAndTime;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setRepairCost(double repairCost) {
            this.repairCost = repairCost;
            return this;
        }

        public Builder copy(DamageReport report) {
            this.id = report.id;
            this.RSVP = report.RSVP;
            this.description = report.description;
            this.dateAndTime = report.dateAndTime;
            this.location = report.location;
            this.repairCost = report.repairCost;
            return this;
        }

        public DamageReport build() {
            return new DamageReport(this);
        }
    }
}


