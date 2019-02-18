package org.training.controller;

import org.training.model.UserRecordsModel;
import org.training.model.entities.UserRecord;
import org.training.model.entities.datafields.AllowedFields;
import org.training.userform.UserForm;

import java.util.*;

public class UserFormController {
    private UserForm userForm;
    private UserRecordsModel userRecordsModel;


    public UserFormController(UserForm userForm) {
        this.userForm = userForm;
        userRecordsModel = UserRecordsModel.instance();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        List<String> fieldList = new LinkedList<>(AllowedFields.FIELD_REGEX.keySet());

        while(true) {
            userForm.printMessage(UserForm.SELECT_FIELD_MESSAGE);
            printFieldList(fieldList);

            int fieldNum = inputFieldNum(fieldList, scanner);
            if(fieldNum == -1) {
                userRecordsModel.saveRecord();
                break;
            }

            String fieldName = getFieldNameByNum(fieldList, fieldNum);

            String formatMessage = String.format(UserForm.ENTER_VALUE, fieldName);
            userForm.printMessage(formatMessage);

            String fieldValue = inputFieldValue(fieldName, scanner);

            userRecordsModel.addField(fieldName, fieldValue);
        }

        printUsers();
    }

    private void printFieldList(List<String> fieldList) {
        for(int i = 0; i < fieldList.size(); i++)
            userForm.printMessage((i+1) + ")" + fieldList.get(i));
    }


    public String getFieldNameByNum(List<String> fieldList, int num) {
        return fieldList.get(num);
    }

    public int inputFieldNum(List<String> fieldList, Scanner scanner) {
        String key = scanner.next();
        if(key.equals("-s"))
            return -1;

        int fieldNum = Integer.parseInt(key);
        fieldNum--;

        while(fieldNum > fieldList.size()) {
            userForm.printMessage(UserForm.WRONG_FIELD_NUMBER);
            userForm.printMessage(UserForm.SELECT_FIELD_MESSAGE);
        }
        return fieldNum;
    }

    public String inputFieldValue(String fieldName, Scanner sc) {
        return sc.next();
    }

    private void saveRecord() {
        userRecordsModel.saveRecord();
    }

    public void printUsers() {
        for(UserRecord record: userRecordsModel.getUserRecords())
            userForm.printMessage(record.toString());
    }
}
