<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des cients</title>
</head>
<body>
	Clients :
	<br>
	<c:forEach items="${clients }" var="client">
		<c:out value="- [${client.num }] ${client.nom } ${ client.prenom } ${ client.telephone }" />
		<br>
	</c:forEach>
	<br> nombre de clients : ${ clientsSize }
	<br>
</body>
</html>