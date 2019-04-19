package services;

import entities.Administrator;
import entities.Check;
import entities.Order;

public interface AdminService {
    Administrator registerAdmin(Administrator administrator);

    Administrator logIn(String login, String password);
    void logOut();

    void acceptOrder(Order order);
    Check prepareCheck(Order order);
}
