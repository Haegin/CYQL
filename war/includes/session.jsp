	<%
	   boolean loggedIn = false;
	   User user = null;
	   if (session.getAttribute("user") != null) {
		   user = (User)session.getAttribute("user");
		   loggedIn = true;
	   }
	%>
