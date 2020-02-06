<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'une adresse</title>
</head>
<body>
	<form method="post" action="creationAdresse">
		<c:import url="formulaireAdresse.jsp"></c:import>
		<br>
		<c:import url="formulaireClient.jsp"></c:import>
		<input type="submit" value="Ajouter" />
	</form>

	<br>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
</body>
</html>