package in.haeg.cyql.server;

import in.haeg.cyql.shared.PMF;
import in.haeg.cyql.shared.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked") public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String md5pass = MD5Sum.hash(req.getParameter("pass"));
        String md5pass2 = MD5Sum.hash(req.getParameter("pass-confirm"));

        if (md5pass.equals(md5pass2)) {
            String csEmail = req.getParameter("user");
            resp.getOutputStream().println("CS Email: " + csEmail);
            String nickname = req.getParameter("nickname");
            String email = req.getParameter("email");
            String firstname = req.getParameter("first-name");
            String lastname = req.getParameter("last-name");
            Date joinDate = new Date();

            PersistenceManager pm = PMF.get().getPersistenceManager();
            String qryExistingUser = "select from " + User.class.getName() + " where m_Email == " + req.getParameter("user");
            List<User> users = (List<User>) pm.newQuery(qryExistingUser).execute();
            if (users.isEmpty()) {
                User newUser = new User(csEmail, firstname, lastname, nickname, email, md5pass, joinDate, joinDate);
                pm.makePersistent(newUser);
                pm.close();
                resp.sendRedirect("login.html");
            } else {
                resp.getOutputStream().println("Sorry, that username already has an account");
            }
        }
    }
}
