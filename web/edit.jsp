<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Smiley</title>
</head>
<body>
<h1>Smiley information</h1>
<form action="smiley" method="POST" accept-charset="UTF-8">
<label >Face</label><input type="text" name="face" value="${smiley.face}" /><br/>
<label>Shortcut</label><input type="text" name="shortcut" value="${smiley.shortcut}" /><br/>
<label>Description</label><input type="text" name="description" value="${smiley.description}" /><br/>
<input type="hidden" name="id" value="${smiley.id}" />
<button type="submit">Submit</button>
</form>
</body>
</html>