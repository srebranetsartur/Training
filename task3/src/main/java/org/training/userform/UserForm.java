package org.training.userform;

public class UserForm {
    public static final String SELECT_FIELD_MESSAGE = "Please, select field to input. Enter -s to save user data";
    public static final String WRONG_FIELD_NUMBER = "Wrong number of field";
    public static final String ENTER_VALUE = "You select %s field. Please enter value: ";
    public static final String INVALID_FIELD_VALUE = "Input value for field %s is invalid. Try again";
    public void printMessage(String message) {
        System.out.println(message);
    }
}
