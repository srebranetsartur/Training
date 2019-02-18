package org.training.model;


import org.training.model.entities.UserRecord;
import org.training.model.entities.datafields.UserField;

import java.util.LinkedList;
import java.util.List;

public final class UserRecordsModel {
    private static UserRecordsModel INSTANCE;

    private final List<UserRecord> userRecords;
    private UserRecord.Builder userRecordBuilder;

    private UserRecordsModel() {
        userRecords = new LinkedList<>();
    }

    public static UserRecordsModel instance() {
        if(INSTANCE == null)
            INSTANCE = new UserRecordsModel();

        return INSTANCE;
    }

    public void saveRecord() {
        userRecords.add(userRecordBuilder.build());
        userRecordBuilder = null;
    }

    public void addField(String fieldName, String fieldValue) {
        if(userRecordBuilder == null)
            userRecordBuilder = new UserRecord.Builder();

        if(UserField.VALIDATOR.validate(fieldName, fieldValue)) {
            UserField userField = new UserField(fieldName, fieldValue);
            userRecordBuilder.addDataField(userField);
        }
        else
            throw new RuntimeException("Wrong field value");

    }

    public List<UserRecord> getUserRecords() {
        return userRecords;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(UserRecord record: userRecords) {
            stringBuilder
                    .append("User")
                    .append("-----------------------")
                    .append(record);
        }

        return stringBuilder.toString();
    }
}
