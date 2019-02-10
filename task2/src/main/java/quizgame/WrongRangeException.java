package quizgame;

public class WrongUpperRangeException extends RuntimeException {
    public WrongUpperRangeException() {
        super();
    }

    public WrongUpperRangeException(String message) {
        super(message);
    }
}
