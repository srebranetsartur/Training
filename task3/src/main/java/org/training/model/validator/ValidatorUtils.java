package org.training.model.validator;

import org.training.model.UserRecordDB;
import org.training.model.regexUtil.BundleHelper;

public final class ValidatorUtils {
    public static boolean validate(String fieldName, String fieldValue) {
        String regex = BundleHelper.getFieldRegex(fieldName);
        Validator validator = () -> fieldValue.matches(regex);

        return validator.validate();
    }

    public static boolean isLoginUnique(String login) {
        return UserRecordDB.usersLogin().contains(login);
    }
}
