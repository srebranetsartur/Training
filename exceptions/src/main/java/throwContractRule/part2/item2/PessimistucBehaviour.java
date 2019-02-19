package throwContractRule.part2.item2;

public class PessimistucBehaviour {
    public class App {
        public static void main(String[] args) {
            throw new Exception(); // тут ошибка компиляции
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Exception

//
//    Мы не можем бросать, но предупредить о «меньшем»
//            import java.io.IOException;

    public class App {
        public static void main(String[] args) throws IOException {
            throw new Exception(); // тут ошибка компиляции
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Exception

//
//    Мы можем предупредить точно о том, что бросаем
    public class App {
        public static void main(String[] args) throws Exception { // предупреждаем о Exception
            throw new Exception(); // и кидаем Exception
        }
    }

//
//    Мы можем предупредить о большем, чем мы бросаем
    public class App {
        public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
            throw new Exception(); // а кидаем только Exception
        }
    }


//    Можем даже предупредить о том, чего вообще нет
    public class App {
        public static void main(String[] args) throws Exception { // пугаем
            // но ничего не бросаем
        }
    }


//    Даже если предупреждаем о том, чего нет — все обязаны бояться
    public class App {
        public static void main(String[] args) {
            f(); // тут ошибка компиляции
        }

        public static void f() throws Exception {
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Exception


//    Хотя они (испугавшиеся) могут перепугать остальных еще больше
    public class App {
        // они пугают целым Throwable
        public static void main(String[] args) throws Throwable {
            f();
        }
        // хотя мы пугали всего-лишь Exception
        public static void f() throws Exception {
        }
    }


//    В чем цель «пессимистичности»? Все достаточно просто.
//    Вы в режиме протипирования «набросали», скажем, класс-утилиту для скачивания из интернета
    public class InternetDownloader {
    public static byte[] (String url) throws IOException {
            return "<html><body>Nothing! It's stub!</body></html>".getBytes();
        }
    }

//    и хотели бы «принудить» пользователей вашего класса УЖЕ ОБРАБАТЫВАТЬ возможное исключение IOException, хотя из реализации-пустышки вы ПОКА НЕ ГЕНЕРИРУЕТЕ такое исключение. Но в будущем — собираетесь.
}
