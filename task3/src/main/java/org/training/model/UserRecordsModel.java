package org.training.model;

import org.training.model.entities.UserRecord;

import java.util.LinkedList;
import java.util.List;

public final class UserRecordsModel {
    private static UserRecordsModel INSTANCE;

    private final List<UserRecord> userRecords;
    private UserRecord userRecord;

    private UserRecordsModel() {
        userRecords = new LinkedList<>();
    }

    private static UserRecordsModel instanceOf() {
        if(INSTANCE == null)
            INSTANCE = new UserRecordsModel();

        return INSTANCE;
    }

    public void addRecord(UserRecord record) {
        userRecords.add(record);
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
