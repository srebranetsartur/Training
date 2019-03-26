package task1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Count the different collection element
 * @throw @{@link NullPointerException} if input parameter is null
 */
public class ElementCountCollection {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));

        Map<Integer, Long> countElementMap = CountHelper.countElement(integers);
        countElementMap.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    /**
     * Helper class to count collection same element entry
     * Uses a map where key is a unique collection entry and value a count
     */
    public static class CountHelper {
        /**
         *
         * @param collection
         * @return map with collection key value and count
         */
        public static Map<Integer, Long> countElement(Collection<Integer> collection) {
            Objects.requireNonNull(collection);

            return collection
                    .stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }
}




