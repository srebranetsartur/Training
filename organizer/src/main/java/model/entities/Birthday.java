package model.entities;

import model.entities.types.EventPriority;
import model.entities.types.EventType;
import model.notification.Notification;

import java.time.LocalDateTime;

public class Birthday extends Event {
    public Birthday() {
    }

    public Birthday(String title, LocalDateTime startDateTime, EventType type, EventPriority priority, Notification notification) {
        super(title, startDateTime, type, priority, notification);
    }
}
