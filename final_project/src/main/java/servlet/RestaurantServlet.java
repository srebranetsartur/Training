package servlet;

import command.Command;
import command.admin.LoginAdminСommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/*")
public class RestaurantServlet extends HttpServlet {
    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commandMap.put("login", new LoginAdminСommand());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processCommand(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processCommand(req, resp);
    }

    private void processCommand(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getRequestURI();
        Command command = commandMap.getOrDefault(path, (request, response) -> "pages/admin/login.jsp");

        String page = command.doCommand(req, resp);
        if(page.contains("forward")) {
            resp.sendRedirect(page.replace("redirect", ""));
        }
        else {
            req.getRequestDispatcher(page).forward(req, resp);
        }

    }

}
