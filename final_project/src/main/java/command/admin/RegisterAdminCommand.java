package command.admin;

import command.Command;
import dao.impl.JdbcAdminDAO;
import entities.Administrator;
import services.AdminService;
import services.impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class RegisterAdminCommand implements Command {
    private AdminService adminService;

    public RegisterAdminCommand() {
        JdbcAdminDAO adminDAO = new JdbcAdminDAO();
        adminService = new AdminServiceImpl(adminDAO);
    }

    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String number = req.getParameter("number");

        Administrator administrator = new Administrator(login, password, firstName, lastName, birthday, number);

        adminService.registerAdmin(administrator);

        return "/login";
    }
}
