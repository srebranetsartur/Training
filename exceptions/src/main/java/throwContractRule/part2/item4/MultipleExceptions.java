package throwContractRule.part2.item4;

public class MultipleExceptions
//Рассмотрим ситуацию с кодом, который может бросать проверяемые исключения разных типов.
//        Далее учитывайте, что EOFException и FileNotFoundException — потомки IOException.
//
//        Мы можем точно указать, что выбрасываем
        import java.io.EOFException;
        import java.io.FileNotFoundException;

public class App {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

    или вот так
        import java.io.EOFException;
        import java.io.FileNotFoundException;

public class App {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {...}
    public static void f1() throws FileNotFoundException {...}
}


//    А можем «испугать» сильнее (предком обоих исключений)
        import java.io.EOFException;
        import java.io.FileNotFoundException;
        import java.io.IOException;

public class App {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

    или вот так
        import java.io.EOFException;
        import java.io.FileNotFoundException;

public class App {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {...}
    public static void f1() throws FileNotFoundException {...}
}


//    Можно и вот так: EOFException и FileNotFoundException «обобщаем до» IOException,
// а InterruptedException «пропускаем нетронутым» (InterruptedException — НЕ потомок IOException)
        import java.io.EOFException;
        import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        f0();
        f1();
        f2();
    }
    public static void f0() throws EOFException {...}
    public static void f1() throws FileNotFoundException {...}
    public static void f2() throws InterruptedException {...}
}
}
