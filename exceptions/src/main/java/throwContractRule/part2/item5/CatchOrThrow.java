package throwContractRule.part2.item5;

public class CatchOrThrow {
//    5. Или catch, или throws
//
//    Не надо пугать тем, что вы перехватили
//    так
    public class App {
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (Exception e) {
                // ...
            }
        }
    }


//    или так (ставим catch по предку и точно перехватываем)
    public class App {
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (Throwable e) {
                // ...
            }
        }
    }


//    Но если перехватили только потомка, то не выйдет
    public class App {
        public static void main(String[] args) {
            try {
                throw new Throwable();
            } catch (Exception e) {
                // ...
            }
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable
//
//
//    Не годится, естественно, и перехватывание «брата»
    public class App {
        public static void main(String[] args) {
            try {
                throw new Exception();
            } catch (Error e) {
                // ...
            }
        }
    }

//>> COMPILATION ERROR: unhandled exception: java.lang.Exception
//
//
//    Если вы часть перехватили, то можете этим не пугать
import java.io.EOFException;
import java.io.FileNotFoundException;

    public class App {
        // EOFException перехватили catch-ом, им не пугаем
        public static void main(String[] args) throws FileNotFoundException {
            try {
                if (System.currentTimeMillis() % 2 == 0) {
                    throw new EOFException();
                } else {
                    throw new FileNotFoundException();
                }
            } catch (EOFException e) {
                // ...
            }
        }
    }
}
