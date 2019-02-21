package org.training.model.exception;

public class LoginAlreadyExistException extends RuntimeException {
    public static final String LOGIN_ALREADY_EXIST = "Login %s already exist. Enter a new one";

    public LoginAlreadyExistException(String login) {
        super(String.format(LOGIN_ALREADY_EXIST, login));
    }
}
