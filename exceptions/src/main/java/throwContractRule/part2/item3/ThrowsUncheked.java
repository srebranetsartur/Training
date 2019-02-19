package throwContractRule.part2.item3;

public class ThrowsUncheked {
//    Вызов метода, который «пугает» unchecked исключением не накладывает на нас никаких обязанностей.
    public class App {
        public static void main(String[] args) {
            f();
        }
        public static void f() throws RuntimeException {
        }
    }

//    Эта конструкция служит цели «указать» программисту-читателю кода на то, что ваш метод может выбросить некоторое непроверяемое (unchecked) исключение.

    Пример (java.lang.NumberFormatException — непроверяемое исключение):
            package java.lang;

    public final class Integer extends Number implements Comparable<Integer> {
    ...
        /**
         * ...
         *
         * @param s    a {@code String} containing the {@code int}
         *             representation to be parsed
         * @return     the integer value represented by the argument in decimal.
         * @exception  NumberFormatException  if the string does not contain a
         *               parsable integer.
         */
        public static int parseInt(String s) throws NumberFormatException {
            return parseInt(s,10);
        }
    ...
    }

//Integer.parseInt() может бросить unchecked NumberFormatException на неподходящем аргументе (int k = Integer.parseInt(«123abc»)), это отразили
//— в сигнатуре метода: throws NumberFormatException
//— в документации (javadoc): @ exception
//    но это ни к чему нас не обязывает.

}
