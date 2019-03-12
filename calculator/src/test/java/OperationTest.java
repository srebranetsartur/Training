import calculator.Calculator;
import operation.StandardOperation;
import operation.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {
    @Test
    void testStandardOperation() {
        long arg1 = 6L;
        long arg2 = 4L;

        Calculator<Long> calculator = new Calculator<>();
        assertAll(
                () -> assertEquals(calculator.process(arg1, arg2, StandardOperation.PLUS.operation()), 10L),
                () -> assertEquals(calculator.process(arg1, arg2, StandardOperation.MINUS.operation()), 2L),
                () -> assertEquals(calculator.process(arg1, arg2, StandardOperation.TIMES.operation()), 24L),
                () -> assertEquals(calculator.process(arg1, arg2, StandardOperation.DIVIDE.operation()), 6L/4L)
        );
    }

    @Test
    void testStringOperation() {
        String phrase1 = "Coding ";
        String phrase2 = "is cool";
        String result = "Coding is cool";
        Calculator<String> calculator = new Calculator<>();

        assertEquals(calculator.process(phrase1, phrase2, StringOperation.PLUS.operation()), result);
    }
}
