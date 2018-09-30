<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smileys List</title>
</head>
<body>

<table><tr><th>Smiley</th><th>Shortcut</th></tr>
<c:forEach items="${list}" var="smiley">
	<tr><td>${smiley.face}</td><td>${smiley.shortcut}</td></tr>
</c:forEach>
</table>
<a href='hello'>Go to welcome page</a><br/>
</body>
</html>