package in.haeg.cyql.server;

import java.util.List;

import in.haeg.cyql.shared.PMF;
import in.haeg.cyql.shared.User;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginManager {

    @SuppressWarnings("unchecked") public static void login(HttpServletRequest req, String username, String password) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        String qryUser = "select from " + User.class.getName() + " where m_NickName == " + req.getParameter("user");
        try {
            List<User> users = (List<User>) pm.newQuery(qryUser).execute();
            if (users.size() == 1) {
                User user = users.get(0);
                if (user.getPassword().equals(MD5Sum.hash(req.getParameter("pass")))) {
                    // get the session object and set the user
                    HttpSession session = req.getSession();
                    User detachedUser = pm.detachCopy(user);
                    session.setAttribute("user", detachedUser);
                }
            }
        } finally {
            pm.close();
        }
    }

    public static boolean checkLogin(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
