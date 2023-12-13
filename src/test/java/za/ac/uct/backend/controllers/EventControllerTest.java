package za.ac.uct.backend.controllers;
/*
package za.ac.uct.backend.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.uct.controllers.EventController;
import za.ac.uct.domain.Event;
import za.ac.uct.domain.PriceGroup;
import za.ac.uct.service.impl.EventServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventController.class)
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventServiceImpl eventService;

    private List<Event> eventList;

    @BeforeEach
    public void setUp() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder().id(1).licensePlate("ABC123").make("Toyota").model("Camry").priceGroup(PriceGroup.STANDARD).build());
        eventList.add(Event.builder().id(2).licensePlate("DEF456").make("Honda").model("Accord").priceGroup(PriceGroup.LUXURY).build());
        eventList.add(Event.builder().id(3).licensePlate("DEF456").make("Toyota").model("Aygo").priceGroup(PriceGroup.ECONOMY).build());
    }

    @Test
    public void testGetEvents() throws Exception {
        // Mock the service method
        when(eventService.getAll()).thenReturn((ArrayList<Event>) eventList);

        // Perform the GET request
        mockMvc.perform(get("/api/events/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].make").value("Toyota"))
                .andExpect(jsonPath("$[0].model").value("Camry"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].make").value("Honda"))
                .andExpect(jsonPath("$[1].model").value("Accord"));
    }

    @Test
    public void testGetEconomyEvents() throws Exception {
        // Mock the service method
        when(eventService.getAll()).thenReturn((ArrayList<Event>) eventList);

        // Perform the GET request
        mockMvc.perform(get("/api/events/economy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].make").value("Toyota"))
                .andExpect(jsonPath("$[0].model").value("Aygo"));
    }

    @Test
    public void testGetLuxuryEvents() throws Exception {
        // Mock the service method
        when(eventService.getAll()).thenReturn((ArrayList<Event>) eventList);

        // Perform the GET request
        mockMvc.perform(get("/api/events/luxury"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].make").value("Honda"))
                .andExpect(jsonPath("$[0].model").value("Accord"));
    }

    @Test
    public void testGetSpecialEvents() throws Exception {
        // Mock the service method
        when(eventService.getAll()).thenReturn((ArrayList<Event>) eventList);

        // Perform the GET request
        mockMvc.perform(get("/api/events/special"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
*/
