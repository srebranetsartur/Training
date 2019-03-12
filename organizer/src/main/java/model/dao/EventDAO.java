package model.dao;

import model.db.Calendar;
import model.entities.Event;
import model.entities.types.EventType;
import model.factory.EventFactory;
import services.SearchUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static model.db.Calendar.*;

/**
 * Class operates with simulated DataBase
 */
public class EventDAO implements Serializable {
    private Event event;
    private List<Event> events = Calendar.getEvents();

    public EventDAO() {

    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void initEvent(EventType eventType) {
        event = EventFactory.instanceOf(eventType);
    }

    public void saveEvent(Event event) {
        addEvents(event);
    }

    public Event getEvent() {
        return event;
    }

    public List<Event> findAll() {
        return Calendar.getEvents();
    }
    public List<Event> findEventByDate(LocalDateTime eventDate, Event.EventSortField sortField) {
        return SearchUtils.findEventInCurrentDate(eventDate, sortField.getComparator());
    }

    public List<Event> findEventBetweenDateRange(LocalDateTime startEventDate, LocalDateTime endEventDate, Event.EventSortField sortField) {
        return SearchUtils.findEventBetweenDates(startEventDate, endEventDate, sortField.getComparator());
    }
}
