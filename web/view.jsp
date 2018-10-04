<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Smiley</title>
</head>
<body>

<h1>${smiley.description}</h1>

<p>
<b>Icon:</b> ${smiley.face} <br/>
<b>Shortcut:</b> ${smiley.shortcut} <br/>
</p>

<a href="list">Back to the list</a>
</body>
</html>