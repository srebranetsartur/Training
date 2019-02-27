package intstream;

import java.util.*;
import java.util.stream.IntStream;

//Сделать массив int. Из него получить IntStreamTask. Для него
//        1. Найти среднее значение элементов массива
//        2. Найти минимальный элемент, значение и индекс
//        3. Посчитать количество элементов равных нулю
//        4. Посчитать количество элементов больше нуля
//        5. Помножить элементы массива на число
public class IntStreamTask {
    public static void main(String[] args) {

        int[] intArr =  new int[] {20, 15, -3, -5, 10, 11, 0, -2, 10, 45, 34, 22 };

        System.out.println();
    }

    private static double averageValue(int[] integers) {
        Objects.requireNonNull(integers);

        return Arrays.stream(integers).average().getAsDouble();
    }

    private static int[] minElementIndexAndValue(int[] integers) {
        Objects.requireNonNull(integers);

        int[] valueDescription = new int[2];

        int index = Arrays.stream(integers)
                .reduce((i,j) -> integers[i] > integers[j] ? i : j )
                .getAsInt();

        valueDescription[0] = integers[index];
        valueDescription[1] = index;

    }

    private static long zeroElementsCount(int[] integers) {
        Objects.requireNonNull(integers);

        return Arrays.stream(integers)
                .filter(v -> v == 0)
                .count();
    }

    private static long greaterThanZeroElementCount(int[] integers) {
        Objects.requireNonNull(integers);

        return Arrays.stream(integers)
                .filter(v -> v > 0)
                .count();
    }

    private static int[] multiplyValueByFactor(int[] integers, int factor) {
        Objects.requireNonNull(integers);

        return Arrays.stream(integers)
                .map(v -> v * factor)
                .toArray();
    }

}
