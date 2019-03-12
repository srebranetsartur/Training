import model.entities.*;
import model.entities.types.EventType;
import model.factory.EventFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import services.SearchUtils;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventTest {
    @Test
    void ShouldFindOneEvent_WhenDateEqualsToDecember12_1996() {
        LocalDateTime ldt = LocalDateTime.of(1996, Month.DECEMBER, 16 ,0, 0);
        int entitiesFoundCount = SearchUtils.findEventInCurrentDate(ldt, Event.EventSortField.DATE.getComparator()).size();
        assertEquals(1, entitiesFoundCount);
    }

    @Test
    void ShouldFindTwoEvent_InDateRange_ComparedByPriority() {
        LocalDateTime start = LocalDateTime.of(2019, Month.MARCH, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2019, Month.MARCH, 30, 0, 0);

        assertEquals(2, SearchUtils.findEventBetweenDates(start, end, Event.EventSortField.PRIORITY.getComparator()).size());
    }

    @Test
    void ShouldFindZeroEvent() {
        int entitiesFound = SearchUtils.findEventInCurrentDate(LocalDateTime.now(), Event.EventSortField.DATE.getComparator()).size();
        assertEquals(0, entitiesFound);
    }

    @Test
    void ShouldInitEventByType() {
        Event event = EventFactory.instanceOf(EventType.BIRTHDAY);
        assertEquals(Birthday.class, event.getClass());
    }
}
