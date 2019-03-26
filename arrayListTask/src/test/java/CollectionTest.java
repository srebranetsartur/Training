import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.ElementCountCollection;

import java.util.*;

/**
 * Test class for @{@link task1.ElementCountCollection} function
 */
public class CollectionTest {
    @Test
    void shouldThrowNPE() {
        Assertions.assertThrows(NullPointerException.class, () -> ElementCountCollection.CountHelper.countElement(null));
    }

   @Test
   void shouldPrintValidMap() {
       List<Integer> testData = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));

       Map<Integer, Long> result = ElementCountCollection.CountHelper.countElement(testData);
       Map<Integer, Long> expectedResult = new HashMap<Integer, Long>() {{
           put(3, 1L);
           put(2, 1L);
           put(4, 4L);
           put(-6, 1L);
           put(5, 3L);
           put(7, 1L);
       }};

       Assertions.assertEquals(expectedResult, result);

   }
}
