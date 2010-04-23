<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This page does magic</title>
</head>
<body>
	<form action="/magic" method="post" id="magic-form">
		<fieldset>
			<legend>Magic form is magic...</legend>
			<div><input type="submit" value="More Magic" name="magic" /></div>
		</fieldset>
	</form>
	<% if (request.getParameter("done") != null) { %>
	   <p>Mischief managed.</p>
	<% } %>
</body>
</html>