package model;

public class Model {
    public static final String[] VALID_ARGS = {"hello", "world!"};

    private String message;

    public String getMessage() {
        return message;
    }

    public void concatToMessage(String word) {
        if(message == null) {
            message = word;
        }
        else {
            message = message.concat(" " + word);
        }
    }

    //Equals two word in lower registry
    public boolean validateWord(String word, int argIndex) {
        return word.equalsIgnoreCase(VALID_ARGS[argIndex]);
    }
}
