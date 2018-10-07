<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Page</title>
</head>
<body>

<p>Hello <b>Smiley</b> ${empty user ? "guest" : user} ☺</p>
<a href='substitution.html'>Substitution service</a><br/>
<a href='list'>List all smileys</a><br/>
<a href='index.html'>Back to home page</a>

</body>
</html>