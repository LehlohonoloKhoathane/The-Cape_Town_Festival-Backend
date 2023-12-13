package za.ac.uct.factory.impl;
/**
 * DamageReportFactory.java
 * Factory Class for the Damage Report
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 * */
import za.ac.uct.domain.DamageReport;
import za.ac.uct.domain.Rental;

import java.time.LocalDateTime;

public class DamageReportFactory {

    public DamageReport create(){
        return  new DamageReport.Builder().build();
    }

    public static DamageReport createReport(int id, Rental RSVP, String description, LocalDateTime dateAndTime, String location, double repairCost){
        return new DamageReport.Builder().setId(id)
                .setRental(RSVP)
                .setDescription(description)
                .setDateAndTime(dateAndTime)
                .setLocation(location)
                .setRepairCost(repairCost)
                .build();

    }

}
