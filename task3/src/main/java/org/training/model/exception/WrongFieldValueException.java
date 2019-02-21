package org.training.model.exception;

public class WrongFieldValueException extends RuntimeException {
        private static final String MESSAGE = "Field %s has incorrect value: %s";

    public WrongFieldValueException() {

    }

    public WrongFieldValueException(String fieldName, String fieldValue) {
        super(String.format(MESSAGE, fieldName, fieldValue));
    }
}
