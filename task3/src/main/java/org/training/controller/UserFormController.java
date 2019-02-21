package org.training.controller;

import org.training.model.UserRecordsModel;
import org.training.model.entities.UserRecord;
import org.training.model.exception.LoginAlreadyExistException;
import org.training.model.exception.WrongFieldValueException;
import org.training.model.validator.ValidatorUtils;
import org.training.userform.UserForm;

import java.util.*;

public class UserFormController {
    private UserForm userForm;
    private UserRecordsModel userRecordsModel;

    private String[] inputs = new String[InputField.INPUT_FIELD.size()];
    int index = 0;


    public UserFormController(UserForm userForm) {
        this.userForm = userForm;
        userRecordsModel = UserRecordsModel.instance();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        userForm.printMessage(UserForm.START_INPUT);
        while (!scanner.next().equals("-q")) {

            for (String field : InputField.INPUT_FIELD) {
                enterValueForField(field, scanner);
            }

            UserRecord userRecord = new UserRecord(inputs[0], inputs[1], inputs[2], inputs[3]);
            userRecordsModel.saveUserRecord(userRecord);
            index = 0;
            userForm.printMessage(UserForm.SAVE_TO_DB);
            userForm.printMessage("Enter -q to quit the app. Other symbol to continue.Unfinished entity won't commit to database");
        }

        printUsers();
    }

    private void enterValueForField(String fieldName, Scanner scanner) {
        while (true) {
            userForm.printMessage(String.format(UserForm.ENTER_VALUE, fieldName));
            String value = scanner.next();
            try {
                setField(fieldName, value);
                break;
            }
            catch (WrongFieldValueException e) {
                userForm.printMessage(String.format(UserForm.INVALID_FIELD_VALUE, fieldName, value));
            }
            catch (LoginAlreadyExistException e) {
                userForm.printMessage(e.getMessage());
            }
        }
    }

    private void setField(String fieldName, String fieldValue) {
        if(!validateInput(fieldName, fieldValue))
            throw new WrongFieldValueException(fieldName, fieldValue);

        if(fieldName.equals("login") && ValidatorUtils.isLoginUnique(fieldValue))
            throw new LoginAlreadyExistException(fieldValue);

        inputs[index++] = fieldValue;
    }


    private boolean validateInput(String fieldName, String fieldValue) {
        return ValidatorUtils.validate(fieldName, fieldValue);
    }


    private void printUsers() {
        for(UserRecord record: userRecordsModel.getUserRecords())
            userForm.printMessage(record.toString());
    }
}
