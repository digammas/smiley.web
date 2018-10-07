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

<table><tr><th>Smiley</th><th>Shortcut</th><th>Actions</th></tr>
<c:forEach items="${list}" var="smiley">
	<tr>
		<td>${smiley.face}</td>
		<td>${smiley.shortcut}</td>
		<td>
			<a href="smiley?id=${smiley.id}">view</a> |
			<a href="smiley?id=${smiley.id}&act=edit">edit</a> |
			<a href="smiley?id=${smiley.id}&act=delete">delete</a>
		</td>
	</tr>
</c:forEach>
</table>
<a href="smiley?act=new">Create new smiley</a>
<p/>
<a href='index.html'>Go to welcome page</a><br/>
</body>
</html>