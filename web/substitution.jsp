<%@page import="com.acme.smiley.service.SubstitutionService"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! private SubstitutionService service = new SubstitutionService(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Substitution Service</title>
</head>
<body>
<% if ("POST".equalsIgnoreCase(request.getMethod())) {
	String message = request.getParameter("msg");
	message = service.substitute(message);
	%>
	<p>You entered the following message.</p>
	<p><%= message %></p>
	<a href=''>Try again</a><br/>
	<a href='hello'>Go to welcome page</a><br/>
<% } else { %>
	<form action='#' method='POST'>
		<p>Please enter a message.</p>
		<textarea name='msg'>Hello :)</textarea><p/>
		<button type='submit'>Send</button>
	</form>
<% } %>
</body>
</html>