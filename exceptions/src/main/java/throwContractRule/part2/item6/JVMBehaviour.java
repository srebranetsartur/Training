package throwContractRule.part2.item6;

public class JVMBehaviour {
//    Необходимо понимать, что
//— проверка на cheched исключения происходит в момент компиляции (compile-time checking)
//— перехват исключений (catch) происходит в момент выполнения (runtime checking)
    public class App {
        // пугаем Exception
        public static void main(String[] args) throws Exception {
            Throwable t = new Exception(); // и лететь будет Exception
            throw t; // но тут ошибка компиляции
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable


//    Полная аналогия с
    public class App {
        public static void main(String[] args) throws Exception {
            Object ref = "Hello!";  // ref указывает на строку
            char c = ref.charAt(0); // но тут ошибка компиляции
        }
    }
//
//>> COMPILATION ERROR: Cannot resolve method 'charAt(int)'
//
//    Хотя ССЫЛКА ref УКАЗЫВАЕТ на объект типа java.lang.String (у которого имеется метод charAt(int)), но ТИП ССЫЛКИ — java.lang.Object (ссылка типа java.lang.Object на объект типа java.lang.String). Компилятор ориентируется на «левый тип» (тип ссылки, а не тип ссылаемого) и не пропускает такой код.
//
//    Хотя В ДАННОЙ СИТУАЦИИ компилятор мог бы разобрать, что t ссылается на Exception, а ref — на String, но этого уже невозможно сделать при раздельно компиляции. Представьте, что мы МОГЛИ БЫ скомпилировать ОТДЕЛЬНО такой класс, упаковать в jar и распространять
    // НЕ КОМПИЛИРУЕТСЯ! ИССЛЕДУЕМ ГИПОТЕТИЧЕСКУЮ СИТУАЦИЮ!
    public class App {
        public static void f0(Throwable t) throws Exception {
            throw t;
        }
        public static void f1(Object ref){
            char c = ref.charAt(0);
        }
    }


//    А кто-то берет этот класс, добавляет в classpath и вызывает App.f0(new Throwable()) или App.f1(new Integer(42)). В таком случае JVM столкнулась бы с ситуацией, когда от нее требует бросить проверяемое исключение, которое не отследил компилятор (в случае с f0) или вызвать метод, которого нет (в случае с f1)!
//
//    Java — язык со статической типизацией (т.е. отслеживание корректности использования типов (наличие используемых полей, наличие вызываемых методов, проверка на checked исключения, ...) проводится компилятором), запрещает такое поведение. В некоторых языках (языки с динамической типизацией — отслеживание корректности использования типов проводится средой исполнения (оно разрешено, например в JavaScript).
//
//    Компилятор не пропустит этот код, хотя метод main ГАРАНТИРОВАННО НЕ ВЫБРОСИТ ИСКЛЮЧЕНИЯ
    public class App {
        // пугаем Exception
        public static void main(String[] args) throws Exception {
            try {
                Throwable t = new Exception(); // и лететь будет Exception
                throw t; // но тут ошибка компиляции
            } catch (Exception e) {
                System.out.println("Перехвачено!");
            }
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable


    public class App {
        // ТЕПЕРЬ пугаем Throwable
        public static void main(String[] args) throws Throwable {
            try {
                Throwable t = new Exception(); // а лететь будет Exception
                throw t;
            } catch (Exception e) { // и мы перехватим Exception
                System.out.println("Перехвачено!");
            }
        }
    }

//>> Перехвачено!
}
