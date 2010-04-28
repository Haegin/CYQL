<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.jdo.PersistenceManager"%>
<%@page import="in.haeg.cyql.shared.PMF"%>
<%@page import="in.haeg.cyql.shared.Question"%>
<%@page import="in.haeg.cyql.shared.User"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="CS_York_Query_Language.css" />
<title>CS York Query Language</title>
</head>
<body>
    <%@ include file="header.jsp" %>
	<div id="content">
		<% session.removeAttribute("user"); %>
		<p>You have been successfully logged out. You will be sent home momentarily.</p>
		<% response.setHeader("refresh", "3;url=/"); %>
	</div>
	<div id="nav">
	   <ul id="nav-list">
	       <li><a href="login.html">Log In</a></li>
	       <li><a href="register.html">Register</a></li>
	       <li><a href="logout.jsp">Log Out</a></li>
	   </ul>
	</div>
</body>
</html>