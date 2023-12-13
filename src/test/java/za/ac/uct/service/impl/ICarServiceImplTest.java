package za.ac.uct.service.impl;
/*
package za.ac.uct.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.uct.domain.impl.Event;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IEventServiceImplTest {

    private EventServiceImpl eventService;
    @Mock
    private IEventRepositoryImpl eventRepository;


    @BeforeEach
    void setUp() {
        //  eventRepository = Mockito.mock(EventRepository.class);
        MockitoAnnotations.openMocks(this);
        eventService = new EventServiceImpl(eventRepository);
    }


    @Test
    void create_ValidEvent_ReturnsCreatedEvent() {
        // Arrange
        Event event = Event.builder().id(1).licensePlate("ABC123").make("Toyota").model("Camry").build();

        when(eventRepository.create(any(Event.class))).thenReturn(event);

        // Act
        Event createdEvent = eventService.create(event);

        // Assert
        assertNotNull(createdEvent);
        assertEquals(event.getLicensePlate(), createdEvent.getLicensePlate());
        assertEquals(event.getMake(), createdEvent.getMake());
        assertEquals(event.getModel(), createdEvent.getModel());

        verify(eventRepository, times(1)).create(any(Event.class));
    }

    @Test
    void read_ExistingId_ReturnsEvent() {
        // Arrange
        int eventId = 1;
        Event event = Event.builder().id(1).licensePlate("ABC123").make("Toyota").model("Camry").build();

        when(eventRepository.read(eventId)).thenReturn(event);

        // Act
        Event foundEvent = eventService.read(eventId);

        // Assert
        assertNotNull(foundEvent);
        assertEquals(eventId, foundEvent.getId());
        assertEquals(event.getLicensePlate(), foundEvent.getLicensePlate());
        assertEquals(event.getMake(), foundEvent.getMake());
        assertEquals(event.getModel(), foundEvent.getModel());

        verify(eventRepository, times(1)).read(eventId);
    }

    @Test
    void update_ExistingEvent_ReturnsUpdatedEvent() {
        // Arrange
        Event event = Event.builder().id(1).licensePlate("ABC123").make("Toyota").model("Camry").build();
        Event updatedEvent = Event.builder().id(1).licensePlate("XYZ789").make("Honda").model("Accord").build();


        when(eventRepository.update(any(Event.class))).thenReturn(updatedEvent);

        // Act
        Event result = eventService.update(event);

        // Assert
        assertNotNull(result);
        assertEquals(updatedEvent.getId(), result.getId());
        assertEquals(updatedEvent.getLicensePlate(), result.getLicensePlate());
        assertEquals(updatedEvent.getMake(), result.getMake());
        assertEquals(updatedEvent.getModel(), result.getModel());

        verify(eventRepository, times(1)).update(any(Event.class));
    }

    @Test
    void delete_ExistingId_ReturnsTrue() {
        // Arrange
        int eventId = 1;

        when(eventRepository.delete(eventId)).thenReturn(true);

        // Act
        boolean result = eventService.delete(eventId);

        // Assert
        assertTrue(result);

        verify(eventRepository, times(1)).delete(eventId);
    }

    @Test
    void getAll_ReturnsListOfEvents() {
        // Arrange
        List<Event> events = new ArrayList<>();
        events.add(Event.builder().id(1).licensePlate("ABC123").make("Toyota").model("Camry").build());
        events.add(Event.builder().id(2).licensePlate("XYZ789").make("Honda").model("Accord").build());

        when(eventRepository.getAllEvents()).thenReturn(events);

        // Act
        List<Event> result = eventService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(events.size(), result.size());
        assertEquals(events.get(0).getId(), result.get(0).getId());
        assertEquals(events.get(1).getId(), result.get(1).getId());
        // Assert other properties as needed

        verify(eventRepository, times(1)).getAllEvents();
    }
}
*/
