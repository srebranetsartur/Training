package org.training.model.validator;

public class UserFormValidator implements Validator {
    @Override
    public boolean validate(String value, String regex) {
        return value.matches(regex);
    }
}
