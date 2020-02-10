<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Expirée</title>
</head>
<body>
<%
	//HttpSession session = request.getSession();
	session.invalidate();
%>
Session Expirée
</body>
</html>