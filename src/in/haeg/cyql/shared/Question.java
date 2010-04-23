package in.haeg.cyql.shared;


import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable public class Question {

    @PrimaryKey @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) Key m_QuestionID;
    @Persistent private String                                                m_Question;
    @Persistent private String                                                m_Explanation;
    @Persistent private User                                                  m_User;
    @Persistent private Date                                                  m_AskedDate;
    @Persistent private boolean                                               m_Solved = false;
    @Persistent(mappedBy = "m_Question") private List<Answer>                 m_Answers;

    public Question(String a_Question, String a_Explanation, User a_User) {
        setQuestion(a_Question);
        setExplanation(a_Explanation);
        setUser(a_User);
        setAskedDate(new Date());
    }

    /**
     * @param question
     *            the question to set
     */
    public void setQuestion(String question) {
        m_Question = question;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return m_Question;
    }

    /**
     * @param explanation
     *            the explanation to set
     */
    public void setExplanation(String explanation) {
        m_Explanation = explanation;
    }

    /**
     * @return the explanation
     */
    public String getExplanation() {
        return m_Explanation;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        m_User = user;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return m_User;
    }

    /**
     * @param askedDate
     *            the askedDate to set
     */
    public void setAskedDate(Date askedDate) {
        m_AskedDate = askedDate;
    }

    /**
     * @return the askedDate
     */
    public Date getAskedDate() {
        return m_AskedDate;
    }

    /**
     * @param solved
     *            the solved to set
     */
    public void setSolved(boolean solved) {
        m_Solved = solved;
    }

    /**
     * @return the solved
     */
    public boolean isSolved() {
        return m_Solved;
    }

	public void setAnswers(List<Answer> answers) {
		m_Answers = answers;
	}

	public List<Answer> getAnswers() {
		return m_Answers;
	}
}
