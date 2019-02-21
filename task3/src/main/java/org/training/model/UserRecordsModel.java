package org.training.model;


import org.training.model.entities.UserRecord;
import java.util.List;

public final class UserRecordsModel {
    private static UserRecordsModel INSTANCE;

    private UserRecordsModel() {

    }

    public static UserRecordsModel instance() {
        if(INSTANCE == null)
            INSTANCE = new UserRecordsModel();

        return INSTANCE;
    }

    public void saveUserRecord(UserRecord userRecord) {
        UserRecordDB.USER_RECORDS.add(userRecord);
    }

    public List<UserRecord> getUserRecords() {
        return UserRecordDB.USER_RECORDS;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(UserRecord record: UserRecordDB.USER_RECORDS) {
            stringBuilder
                    .append("User")
                    .append("-----------------------")
                    .append(record);
        }

        return stringBuilder.toString();
    }
}
