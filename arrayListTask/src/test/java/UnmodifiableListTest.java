import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task2.UnmodifiableList;

import java.util.ArrayList;

public class UnmodifiableListTest {
    static UnmodifiableList<String> list;

    @BeforeAll
    static void init() {
        list = new UnmodifiableList<>(new ArrayList<>());
    }

    @Test
    void testListOperation() {
        list.add("Hello");
        list.add("Hello");

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void shouldThrowUnsupportedOperationException() {
        UnmodifiableList<String> list = new UnmodifiableList<>(new ArrayList<>());
        list.add("Hello");
        list.add("World");

        Assertions.assertThrows(UnsupportedOperationException.class, () -> list.remove("Hello"));
    }
}
