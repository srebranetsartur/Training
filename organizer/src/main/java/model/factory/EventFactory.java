package model.factory;

import model.entities.*;
import model.entities.types.EventType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import static model.entities.types.EventType.*;

/**
 * Class uses A Factory pattern to create type depending on state
 */
public class EventFactory {
    private static Map<EventType, Supplier<? extends Event>> factoryEvents = new HashMap<>();

    /**
     * Static map init. Only for demonstration purposes
     */
    static {
        factoryEvents.put(BIRTHDAY, Birthday::new);
        factoryEvents.put(DEADLINE, Deadline::new);
        factoryEvents.put(HOLIDAY, Holiday::new);
        factoryEvents.put(HOUSE_CLEANING, HouseCleaning::new);
        factoryEvents.put(PROJECT, Project::new);
        factoryEvents.put(VACATION, Vacation::new);
        factoryEvents.put(WORKOUT, Workout::new);
    }

    /**
     *
     * @param eventType
     * @return new object of type Event
     */
    public static Event instanceOf(EventType eventType) {
        Objects.requireNonNull(eventType);
        return factoryEvents.get(eventType).get();
    }
}
