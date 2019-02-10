package user;

public class GameBoard {
    public enum Message {
        INPUT_RANGE("Enter two value for game range in any order"),
        BOUND_ERROR("Wrong lower range limit. It must be in range: "),
        INPUT_BOUND("Please input a bound to pick a number. Range in 0 to 100)"),
        START_GAME("Number is ready. Game started"),
        ENTER_QUIZ("Please enter your quiz"),
        ALREADY_IN("Almost correct. Take a tip. Find number in this range: "),
        NOT_A_NUMBER("Value must be only number. Try again"),
        NOT_IN_RANGE("Number isn't belong to range"),
        CONGRATULATION("Your answer is correct"),
        ;

        private String message;

        public String getMessage() {
            return message;
        }

        Message(String message) {
            this.message = message;
        }

    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

}
