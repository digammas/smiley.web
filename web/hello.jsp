<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Page</title>
</head>
<body>
<%
String name = request.getParameter("nm");
if (name == null) {
	name = (String) session.getAttribute("user");
} else {
	session.setAttribute("user", name);
}
%>

<p>Hello <b>Smiley</b> <% out.print(name); %> ☺</p>
<a href='substitution'>Substitution service</a><br/>
<a href='index.html'>Back to home page</a>

</body>
</html>