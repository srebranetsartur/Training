package services.impl;

import dao.AdminDAO;
import entities.Administrator;
import entities.Check;
import entities.Order;
import services.AdminService;
import services.exceptions.NotFoundAdminException;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Administrator registerAdmin(Administrator administrator) {
        return adminDAO.save(administrator);
    }

    @Override
    public Administrator logIn(String login, String password) {
        Optional<Administrator> admin = adminDAO.findByLoginAndPassword(login, password);
        if (admin.isPresent()) {
            return admin.get();
        }
        else
            throw new NotFoundAdminException();
    }

    @Override
    public void logOut() {

    }

    @Override
    public void acceptOrder(Order order) {

    }

    @Override
    public Check prepareCheck(Order order) {
        return null;
    }
}
