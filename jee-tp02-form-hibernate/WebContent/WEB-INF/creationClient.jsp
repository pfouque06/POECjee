<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'un client</title>
</head>
<body>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
	<br>
	<form method="post" action="creationClient">
		<c:import url="formulaireClient.jsp"></c:import>
		<br>
		<div align="center"><input type="submit" value="Ajouter" /></div>
	</form>
</body>
</html>