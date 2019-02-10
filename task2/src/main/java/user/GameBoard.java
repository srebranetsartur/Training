package user;

public class View {
    public enum Message {
        BIG_UPPER_BOUND("Wrong upper range limit. It must be less than 100, inclusive"),
        INPUT_BOUND("Please input a bound to pick a number. Range in 0 to 100)"),
        START_GAME("Number is ready. Game started. Please enter your quiz"),
        ENTER_QUIZ("Enter your quiz"),
        NOT_A_NUMBER("Value must be in number")
        ;

        private String message;

        public String getMessage() {
            return message;
        }

        Message(String message) {
            this.message = message;
        }

    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
