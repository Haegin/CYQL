package in.haeg.cyql.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginManager.login(req, req.getParameter("user"), req.getParameter("pass"));
        if (LoginManager.checkLogin(req)) {
            resp.sendRedirect("index.jsp");
        } else {
            resp.getOutputStream().println("Failed to log in.");
        }
    }
}
