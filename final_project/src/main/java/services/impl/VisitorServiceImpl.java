package services.impl;

import dao.MenuDAO;
import dao.VisitorDAO;
import entities.*;
import services.VisitorService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    private MenuDAO menuDAO;
    private VisitorDAO visitorDAO;
    private Order order;

    public VisitorServiceImpl(VisitorDAO visitorDAO, MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
        this.visitorDAO = visitorDAO;
    }

    @Override
    public Menu getRestaurantMenu() {
        Menu menu = new Menu();

        return menu;
    }

    @Override
    public Visitor registerVisitor(Visitor visitor) {
        return visitorDAO.save(visitor);
    }

    @Override
    public Visitor getVisitorByNumber(String number) {
        return null;
    }

    @Override
    public void orderItem(MenuItem menuItem) {
        order.addToOrder(menuItem);
    }

    @Override
    public void cancelOrderItem(MenuItem menuItem) {
        order.removeFromOrder(menuItem);
    }

    @Override
    public Order order(List<MenuItem> menuItems) {
        return null;
    }

    @Override
    public Check getCheck() {
        return null;
    }

    @Override
    public void payCheck(BigDecimal money) {

    }
}
