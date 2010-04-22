<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.jdo.PersistenceManager"%>
<%@page import="in.haeg.cyql.shared.PMF"%>
<%@page import="in.haeg.cyql.shared.Question"%><html>
<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="CS_York_Query_Language.css" />
<title>CS York Query Language</title>
</head>
<body>
    <%@ include file="header.jsp" %>
	<div id="content">
	   <table id="question-table">
	       <tr><th>User</th><th>Question</th><th>Date</th></tr>
			<%
				PersistenceManager pm = PMF.get().getPersistenceManager();
				String qryGetQuestions = "select from " + Question.class.getName() + " order by m_AskedDate desc";
				List<Question> questions = (List<Question>)pm.newQuery(qryGetQuestions).execute();
				for (Question q : questions) {
					System.out.println("<tr><td>" + q.getUser().getNickName() + "</td><td>" + q.getQuestion() + "</td><td>" + q.getAskedDate() + "</td></tr>");
				}
			%>
		</table>
	</div>
	<div id="nav">
	   <ul id="nav-list">
	       <li><a href="login.html">Log In</a></li>
	       <li><a href="register.html">Register</a></li>
	   </ul>
	</div>
</body>
</html>