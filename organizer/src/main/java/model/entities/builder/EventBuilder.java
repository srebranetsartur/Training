package model.entities.builder;

import model.entities.Event;
import model.entities.types.EventPriority;
import model.entities.types.EventType;
import model.factory.EventFactory;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDateTime;

@ManagedBean
@Named
@RequestScoped
public class EventBuilder {
    private String title;
    private EventType type;
    private LocalDateTime startDate;
    private EventPriority priority;
    private boolean repeat;

    public Event build() {
        Event event = EventFactory.instanceOf(type);
        event.setTitle(title);
        event.setType(type);
        event.setStartDateTime(startDate);
        event.setPriority(priority);
        event.setRepeat(repeat);

        return event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventPriority getPriority() {
        return priority;
    }

    public void setPriority(EventPriority priority) {
        this.priority = priority;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
}
