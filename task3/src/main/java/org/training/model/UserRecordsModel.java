package org.training.model;

import org.training.model.entities.UserRecord;
import org.training.model.validator.Validator;

import java.util.LinkedList;
import java.util.List;

public final class UserRecordsModel {
    private final List<UserRecord> userRecords;
    private Validator validator;

    public UserRecordsModel(Validator validator) {
        userRecords = new LinkedList<>();
        this.validator = validator;
    }

    public void addRecord(UserRecord record) {
        userRecords.add(record);
    }

    public boolean validate(String value, String regex) {
        return validator.validate(value, regex);
    }
}
