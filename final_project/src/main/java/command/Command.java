package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Command {
    String doCommand(HttpServletRequest req, HttpServletResponse resp);
}
