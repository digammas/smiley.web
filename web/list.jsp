<%@page import="com.acme.smiley.model.Smiley"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smileys List</title>
</head>
<body>

<table><tr><th>Smiley</th><th>Shortcut</th></tr>
<%
List<Smiley> list = (List<Smiley>) request.getAttribute("list");
if (list != null) {
	for (Smiley smiley : list) {
	%> 
	<tr><td><%= smiley.getFace() %></td><td><%= smiley.getShortcut() %></td></tr>
	<%
	}
}
%>
</table>
<a href='hello'>Go to welcome page</a><br/>
</body>
</html>