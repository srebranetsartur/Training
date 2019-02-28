import intstream.IntStreamTask;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntStreamTaskTest {
    private int[] testedArray = {20, 30, 0, 0, -10, 15, -5, 11, 42, 3, 0};

    @Test
    void shouldThrowException_IfInputArrayIsNull() {
        Class nullPointerException = NullPointerException.class;
        assertAll(
                () -> assertThrows(nullPointerException, () -> IntStreamTask.averageValue(null)),
                () -> assertThrows(nullPointerException, () -> IntStreamTask.greaterThanZeroElementCount(null)),
                () -> assertThrows(nullPointerException, () -> IntStreamTask.minElementIndexAndValue(null)),
                () -> assertThrows(nullPointerException, () -> IntStreamTask.multiplyValueByFactor(null, 2)),
                () -> assertThrows(nullPointerException, () -> IntStreamTask.zeroElementsCount(null))
        );
    }

    @Test
    void ShouldThrowException_IfArrayIsEmpty() {
        int[] a = {};
        assertThrows(Exception.class, () -> IntStreamTask.averageValue(a));
    }

    @Test
    void countOfZeros_ShouldEqualsTo_3() {
        assertEquals(3L, IntStreamTask.zeroElementsCount(testedArray));
    }

    @Test
    void countOfElementGreaterThanZero_ShouldEqualsTo_6() {
        assertEquals(6L, IntStreamTask.greaterThanZeroElementCount(testedArray));
    }

    @Test
    void shouldReturn_4_And_Negative10_AsArrayMinimumIndex_And_Value() {
        int[] result = {-10, 4};
        assertArrayEquals(result, IntStreamTask.minElementIndexAndValue(testedArray));
    }

    @Test
    void shouldReturn_AverageValue() {
        double result = 106/11.0;
        assertEquals(result, IntStreamTask.averageValue(testedArray));
    }
}
