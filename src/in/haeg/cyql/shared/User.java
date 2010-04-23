package in.haeg.cyql.shared;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable public class User {

    @SuppressWarnings("unused") @PrimaryKey @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Key m_UserID;
    @Persistent private String                                                                                    m_CSUserName;
    @Persistent private String                                                                                    m_FirstName;
    @Persistent private String                                                                                    m_LastName;
    @Persistent private String                                                                                    m_NickName;
    @Persistent private String                                                                                    m_Email;
    @Persistent private String                                                                                    m_Password;
    @Persistent private Date                                                                                      m_JoinDate;
    @Persistent private Date                                                                                      m_CSJoinDate;
    @Persistent(mappedBy = "m_User") private List<Question>                                                       m_Questions;

    public User(String a_CSUserName, String a_FirstName, String a_LastName, String a_NickName, String a_Email, String a_Password, Date a_JoinDate, Date a_CSJoinDate) {
        setCSUserName(a_CSUserName);
        setFirstName(a_FirstName);
        setLastName(a_LastName);
        setNickName(a_NickName);
        setEmail(a_Email);
        setPassword(a_Password);
        setJoinDate(a_JoinDate);
        setCSJoinDate(a_CSJoinDate);
        m_UserID = KeyFactory.createKey(User.class.getSimpleName(), m_CSUserName);
    }

    public String getCSUserName() {
        return m_CSUserName;
    }

    public void setCSUserName(String a_CSUserName) {
        m_CSUserName = a_CSUserName;
    }

    public String getFirstName() {
        return m_FirstName;
    }

    public void setFirstName(String a_FirstName) {
        m_FirstName = a_FirstName;
    }

    public String getLastName() {
        return m_LastName;
    }

    public void setLastName(String a_LastName) {
        m_LastName = a_LastName;
    }

    public String getNickName() {
        return m_NickName;
    }

    public void setNickName(String a_NickName) {
        m_NickName = a_NickName;
    }

    public void setEmail(String email) {
        m_Email = email;
    }

    public String getEmail() {
        return m_Email;
    }

    public void setPassword(String password) {
        m_Password = password;
    }

    public String getPassword() {
        return m_Password;
    }

    public Date getJoinDate() {
        return m_JoinDate;
    }

    public void setJoinDate(Date a_JoinDate) {
        m_JoinDate = a_JoinDate;
    }

    public Date getCSJoinDate() {
        return m_CSJoinDate;
    }

    public void setCSJoinDate(Date a_CSJoinDate) {
        m_CSJoinDate = a_CSJoinDate;
    }

    public void setQuestions(List<Question> questions) {
        m_Questions = questions;
    }

    public List<Question> getQuestions() {
        return m_Questions;
    }

}
