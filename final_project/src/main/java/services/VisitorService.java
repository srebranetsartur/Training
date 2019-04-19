package services;

import entities.*;

import java.math.BigDecimal;
import java.util.List;

public interface VisitorService {
    Visitor registerVisitor(Visitor visitor);
    Visitor getVisitorByNumber(String number);
    Menu getRestaurantMenu();
    void orderItem(MenuItem menuItem);
    void cancelOrderItem(MenuItem menuItem);

    Order order(List<MenuItem> menuItems);
    Check getCheck();
    void payCheck(BigDecimal money);
}
