package in.haeg.cyql.shared;


import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable public class Answer {

    @PrimaryKey @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) Key m_AnswerID;
    @Persistent private Question                                              m_Question;
    @Persistent private User                                                  m_User;
    @Persistent private Date                                                  m_PostedDate;
    @Persistent private boolean                                               m_Accepted;

    /**
     * @param a_AnswerID
     * @param a_Question
     * @param a_User
     * @param a_PostedDate
     * @param a_Accepted
     */
    public Answer(Question a_Question, User a_User, Date a_PostedDate, boolean a_Accepted) {
        setQuestion(a_Question);
        setUser(a_User);
        setPostedDate(a_PostedDate);
        setAccepted(a_Accepted);
    }

    /**
     * @param question
     *            the question to set
     */
    public void setQuestion(Question question) {
        m_Question = question;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return m_Question;
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
     * @param postedDate
     *            the postedDate to set
     */
    public void setPostedDate(Date postedDate) {
        m_PostedDate = postedDate;
    }

    /**
     * @return the postedDate
     */
    public Date getPostedDate() {
        return m_PostedDate;
    }

    /**
     * @param accepted
     *            the accepted to set
     */
    public void setAccepted(boolean accepted) {
        m_Accepted = accepted;
    }

    /**
     * @return the accepted
     */
    public boolean isAccepted() {
        return m_Accepted;
    }

}
