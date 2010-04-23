<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="javax.jdo.PersistenceManager"%>
<%@page import="in.haeg.cyql.shared.PMF"%>
<%@page import="in.haeg.cyql.shared.Question"%>
<%@page import="in.haeg.cyql.shared.User"%>
<%@page import="java.util.List"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="CS_York_Query_Language.css" />
<title>CS York Query Language</title>
</head>
<body>
	<%
	   boolean loggedIn = false;
	   User user = null;
	   if (session.getAttribute("user") != null) {
		   user = (User)session.getAttribute("user");
		   loggedIn = true;
	   }
	%>
    <%@ include file="header.jsp" %>
	<div id="content">
	   <table id="question-table">
	       <tr><th>User</th><th>Question</th><th>Date</th></tr>
			<%
				PersistenceManager pm = PMF.get().getPersistenceManager();
				String qryGetQuestions = "select from " + Question.class.getName() + " order by m_AskedDate desc";
				List<Question> questions = (List<Question>)pm.newQuery(qryGetQuestions).execute();
				for (Question q : questions) {
					%>
					<tr><td><%=q.getUser().getNickName()%></td><td><%=q.getQuestion()%></td><td><%=q.getAskedDate()%></td></tr>
					<%
				}
			%>
		</table>
		<% if (loggedIn) { %>
		<form id="add-question-form" action="/ask" method="post">
		<fieldset>
		<legend>Ask a new question</legend>
		    <div><label>Question</label><input type="text" name="question" id="add-question-text"></input></div>
		    <div><label>Explanation</label><textarea cols=30 rows=8 name="explanation" id="add-question-explanation"></textarea></div>
			<div><input type="submit" value="Ask" name="add-question-submit" /></div>
		</fieldset>
		</form>
		<% } %>
	</div>
	<div id="nav">
	   <ul id="nav-list">
	   <% if (!loggedIn) { %>
	       <li><a href="login.html">Log In</a></li>
	       <li><a href="register.html">Register</a></li>
	   <% } else { %>
	       <li>Logged in as <%= user.getNickName() %></li>
	       <li>First Name: <%= user.getFirstName() %></li>
	       <li>Last Name: <%= user.getLastName() %></li>
	       <li>CS Username: <%= user.getCSUserName() %></li>
	       <li>Joined Date: <%= user.getJoinDate() %></li>
	       <li>Email: <%= user.getEmail() %></li>
	   <% } %>
	   </ul>
	</div>
</body>
</html>