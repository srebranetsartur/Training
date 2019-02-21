package org.training.model;

import org.training.model.entities.UserRecord;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class UserRecordDB {
    public static final List<UserRecord> USER_RECORDS = new LinkedList<>();

    public static List<String> usersLogin() {
        return USER_RECORDS.stream().map(UserRecord::getLogin).collect(Collectors.toList());
    }
}
