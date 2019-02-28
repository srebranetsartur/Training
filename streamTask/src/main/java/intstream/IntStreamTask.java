package intstream;

import java.util.*;
import java.util.stream.IntStream;

//Сделать массив int. Из него получить IntStreamTask. Для него
//        1. Найти среднее значение элементов массива
//        2. Найти минимальный элемент, значение и индекс
//        3. Посчитать количество элементов равных нулю
//        4. Посчитать количество элементов больше нуля
//        5. Помножить элементы массива на число

/**
 * Class perform some task over the array of ints value
 * All method uses Stream API and lambda to find a specific result
 */
public class IntStreamTask {
    private static class Validator {
        private static int[] requiredValidArray(int[] array) {
            Objects.requireNonNull(array);

            if(array.length == 0)
                throw new EmptyArrayException("Input array is empty");

            return array;

        }

        private static class EmptyArrayException extends RuntimeException {
            private EmptyArrayException(String s) {
                super(s);
            }
        }
    }
    public static void main(String[] args) {

        int[] intArr =  new int[] {20, 15, -3, -5, 10, 11, 0, -2, 10, 45, 34, 22 };

        System.out.println();
    }

    /**
     * Uses to find a average value of array
     * @param integers
     * @return double using the stream api average method
     * @throws NullPointerException if integers is null
     */
    public static double averageValue(int[] integers) {
        Objects.requireNonNull(integers);

        return Arrays.stream(integers).average().getAsDouble();
    }

    /**
     * Method find a a min element index and value
     * @param integers
     * @return array where first elements is index, and second - value
     * @throws NullPointerException if integers is null
     */
    public static int[] minElementIndexAndValue(int[] integers) {
        Validator.requiredValidArray(integers);

        int[] valueDescription = new int[2];

        int index = IntStream.range(0, integers.length-1)
                .reduce((i,j) -> integers[i] < integers[j] ? i : j )
                .getAsInt();

        valueDescription[0] = integers[index];
        valueDescription[1] = index;

        return valueDescription;
    }

    /**
     * Find how many zeros array include
     * @param integers
     * @return count of zero elements
     */
    public static long zeroElementsCount(int[] integers) {
        Validator.requiredValidArray(integers);

        return Arrays.stream(integers)
                .filter(v -> v == 0)
                .count();
    }


    /**
     * Find a positive value in input array
     * @param integers
     * @return count of positive value
     */
    public static long greaterThanZeroElementCount(int[] integers) {
        Validator.requiredValidArray(integers);

        return Arrays.stream(integers)
                .filter(v -> v > 0)
                .count();
    }

    /**
     * Multiply each array value by input factor
     * @param integers
     * @param factor
     * @return new array of values
     */
    public static int[] multiplyValueByFactor(int[] integers, int factor) {
        Validator.requiredValidArray(integers);

        return Arrays.stream(integers)
                .map(v -> v * factor)
                .toArray();
    }

}