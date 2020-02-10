<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP Formulaire</title>
</head>
<body>
<%
	//HttpSession session = request.getSession();
	session.invalidate();
%>
<c:import url="/WEB-INF/linksListe.jsp" />
<div align="center">
<h4>Session Expirée</h4>
</div>
</body>
</html>