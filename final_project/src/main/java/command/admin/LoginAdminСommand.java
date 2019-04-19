package command.admin;

import command.Command;
import dao.AdminDAO;
import dao.impl.JdbcAdminDAO;
import entities.Administrator;
import services.AdminService;
import services.impl.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAdminСommand implements Command {
    private AdminService adminService;

    public LoginAdminСommand() {
        AdminDAO adminDAO = new JdbcAdminDAO();
        adminService = new AdminServiceImpl(adminDAO);
    }
    @Override
    public String doCommand(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Administrator administrator = adminService.logIn(login, password);

        if(administrator != null) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", administrator);
        }

        return "/orders";
    }
}
