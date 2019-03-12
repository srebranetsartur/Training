package model.db;

import model.entities.*;
import model.entities.types.EventPriority;
import model.entities.types.EventType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calendar implements Serializable {
    private static final List<Event> events = new ArrayList<>();

    static {
        Calendar.getEvents().addAll(Stream.of(new Birthday("Best friend b", LocalDateTime.of(1996, Month.DECEMBER, 16, 0, 0), EventType.BIRTHDAY,
                        EventPriority.EXTREME_HIGH, null),

                new Birthday("Same day birthday", LocalDateTime.of(1996, Month.DECEMBER, 16, 0, 0), EventType.BIRTHDAY,
                        EventPriority.MEDIUM, null),

                new Project("Java P", LocalDateTime.now().plusDays(5), EventType.PROJECT,
                        EventPriority.MEDIUM, null),

                new Holiday("8March", LocalDateTime.of(2019, 3, 9, 0, 0),
                        EventType.HOLIDAY,
                        EventPriority.EXTREME_HIGH, null),

                new Deadline("Project Deploy", LocalDateTime.now().plusMonths(2L),
                        EventType.DEADLINE,
                        EventPriority.EXTREME_HIGH, null)
        ).collect(Collectors.toList()));
    }

    public static void addEvents(Event event) {
        events.add(event);
    }

    public static List<Event> getEvents() {
        return events;
    }
}
