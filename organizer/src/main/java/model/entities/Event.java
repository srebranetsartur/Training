package model.entities;

import model.entities.types.EventPriority;
import model.entities.types.EventType;
import model.notification.Notification;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public abstract class Event implements Comparable<Event> {
    private String title;
    private LocalDateTime startDateTime;
    private EventType type;
    private EventPriority priority;
    private Optional<Notification> notification;
    private boolean repeat;

    public enum EventSortField {
        DATE(Comparator.comparing(e -> e.startDateTime)),
        PRIORITY(Comparator.comparing(e -> e.priority.getPriority()));

        private Comparator<Event> comparator;

        EventSortField(Comparator<Event> comparator) {
            this.comparator = comparator;
        }

        public Comparator<Event> getComparator() {
            return comparator;
        }
    }

    protected Event() {

    }

    protected Event(String title, LocalDateTime startDateTime, EventType type,
                    EventPriority priority, Notification notification) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.type = type;
        this.priority = priority;
        this.notification = Optional.ofNullable(notification);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
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

    public Notification getNotification() {
        return notification.get();
    }

    public void setNotification(Notification notification) {
        this.notification = Optional.ofNullable(notification);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Event))
            return false;
        Event event = (Event) obj;
        return event.title.equals(title) && event.startDateTime.isEqual(startDateTime)
                && event.priority.equals(priority) && notification.get().equals(notification.get())
                && event.repeat == repeat;
    }

    @Override
    public int hashCode() {
        int hash = title.hashCode();
        hash = 31*startDateTime.hashCode() + hash;
        hash = 31*priority.hashCode() + hash;
        hash = 31*notification.hashCode() + hash;
        hash = 31*Boolean.hashCode(repeat) + hash;

        return hash;
    }

    @Override
    public int compareTo(Event o) {
        return EventSortField.DATE.getComparator().compare(this, o);
    }
}
