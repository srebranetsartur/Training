package quizgame;

public class WrongRangeException extends RuntimeException {
    public WrongRangeException() {
        super();
    }

    public WrongRangeException(String message) {
        super(message);
    }
}
