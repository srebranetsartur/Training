package controller;

import model.dao.EventDAO;
import model.entities.Event;
import model.entities.types.EventPriority;
import model.entities.types.EventType;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ManagedBean
@ApplicationScoped
public class EventsController implements Serializable {
    private EventDAO eventDAO;
    private List<Event> events;

    /**
     * Wrong issue. Only for demonstration purpose
     * Use Dependency Injection in future release
     */
    public EventsController() {
        eventDAO = new EventDAO();
        events = eventDAO.getEvents();
    }

    public List<Event> getEvents() {
        return events;
    }

    public EventPriority[] getEventPriorities() {
        return EventPriority.values();
    }

    public EventType[] getEventTypes() { return EventType.values(); }

    public void addEvent(Event event) {
        eventDAO.saveEvent(event);
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

}
