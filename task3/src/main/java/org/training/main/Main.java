package org.training.main;

import org.training.controller.UserFormController;
import org.training.userform.UserForm;

public class Main {

    public static void main(String[] args) {
        UserForm userForm = new UserForm();
        UserFormController controller = new UserFormController(userForm);

        controller.execute();
    }
}
