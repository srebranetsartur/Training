package services;

import model.db.Calendar;
import model.entities.Event;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Utility class for searching data through event collection
 * Depending on various @{@link Comparator} result order may sorted differently
 */
public class SearchUtils {
    public static List<Event> findEventInCurrentDate(LocalDateTime dateTime, Comparator<Event> comparator) {
        Objects.requireNonNull(dateTime);
        comparator = initDefaultValidatorIfNull(comparator);

        return Calendar.getEvents().stream()
                .filter((e) -> e.getStartDateTime().equals(dateTime))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static List<Event> findEventBetweenDates(LocalDateTime startDateTime, LocalDateTime endDateTime, Comparator<Event> comparator) {
        Objects.requireNonNull(startDateTime);
        Objects.requireNonNull(endDateTime);

        comparator = initDefaultValidatorIfNull(comparator);

        return Calendar.getEvents().stream()
                .filter((e -> {
                    LocalDateTime dt = e.getStartDateTime();
                    return dt.isAfter(startDateTime) && dt.isBefore(endDateTime);
                }))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private static Comparator<Event> initDefaultValidatorIfNull(Comparator<Event> comparator) {
        return comparator == null ? Event.EventSortField.DATE.getComparator() : comparator;
    }
}
