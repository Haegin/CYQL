package in.haeg.cyql.server;

import in.haeg.cyql.shared.PMF;
import in.haeg.cyql.shared.Question;
import in.haeg.cyql.shared.User;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Magic extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4497956542713143645L;

	@SuppressWarnings("unchecked") public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        String qry = "select from " + User.class.getName();
        List<User> users = (List<User>) pm.newQuery(qry).execute();
        pm.deletePersistentAll(users);
        qry = "select from " + Question.class.getName();
        List<Question> questions = (List<Question>) pm.newQuery(qry).execute();
        pm.deletePersistentAll(questions);
        resp.sendRedirect("magic.jsp?done=1");
    }

}
