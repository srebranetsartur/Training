package org.training.userform;

public class UserForm {
    public static final String START_INPUT = "Enter -q to quit the app. Other symbol to continue." +
            "Unfinished entity won't commit to database";
    public static final String SAVE_TO_DB = "Commit to DataBase";
    public static final String ENTER_VALUE = "Enter value for %s field:  ";
    public static final String INVALID_FIELD_VALUE = "Field %s with value: %s is invalid. Try again";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
