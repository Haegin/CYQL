package in.haeg.cyql.server;

import in.haeg.cyql.shared.PMF;
import in.haeg.cyql.shared.Question;
import in.haeg.cyql.shared.User;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

public class AddQuestion extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 923913280680224430L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String question = req.getParameter("question");
		Text explanation = new Text(req.getParameter("explanation"));
		User user = (User) req.getSession().getAttribute("user");
		
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Question newQuestion = new Question(question, explanation, user);
        pm.makePersistent(newQuestion);
        pm.close();
        resp.sendRedirect("QuestionPage.jsp");
	}
}
