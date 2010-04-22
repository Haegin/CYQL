package in.haeg.cyql.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginManager.login(req, req.getParameter("user"), req.getParameter("pass"));
        if (LoginManager.checkLogin(req)) {
            resp.getOutputStream().println("Successfully logged in!");
        } else {
            resp.getOutputStream().println("Failed to log in.");
        }
    }
}
