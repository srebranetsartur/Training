package org.training.controller;

import org.training.model.entities.UserRecord;
import org.training.model.entities.datafields.UserField;
import org.training.userform.UserForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFormController {
    private UserForm userForm;
    private List<UserRecord> userRecords;

    public UserFormController(UserForm userForm) {
        this.userForm = userForm;
        userRecords = new ArrayList<>();
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        UserRecord.Builder builder = new UserRecord.Builder();
        while(true) {
            userForm.printMessage("Enter a field to add");
            String fieldName = scanner.next();
            userForm.printMessage("Enter value");
            String value = scanner.next();

            UserField field = new UserField(fieldName, value);
            builder.addDataField(field);
            break;
        }

        UserRecord userRecord = builder.build();
        userRecords.add(userRecord);
    }

    public void printUsers() {
        for(UserRecord record: userRecords)
            userForm.printMessage(record.toString());
    }
}
