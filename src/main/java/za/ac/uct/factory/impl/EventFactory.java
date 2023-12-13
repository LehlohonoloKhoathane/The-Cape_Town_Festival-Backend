package za.ac.uct.factory.impl;
/**
 * Author: Lehlohnolo Khoathane
 * Date: 24/11/2023
 * File: EventFactory.java
 * */
import org.springframework.stereotype.Component;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;
import za.ac.uct.factory.IFactory;




@Component
public class EventFactory implements IFactory<Event> {


    public Event createEvent(int id, String make, String model, int year, String category, PriceGroup priceGroup, String licensePlate, boolean isAvailable) {
        return Event.builder()

                .id(id)
                .make(make)
                .model(model)
                .year(year)
                .category(category)
                .priceGroup(priceGroup)
                .licensePlate(licensePlate)
                .isAvailable(isAvailable)
                .build();
    }


    @Override
    public Event create() {
        return Event.builder().build();
    }


    public Event create(Event event) {
        return Event.builder()
                .copy(event)
                .build();
    }
}

