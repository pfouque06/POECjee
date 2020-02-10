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
	<div align="center">
		<h2>Formulaire client</h2>
		<span>
		Le client ${ client.id } ${ client.prenom } ${ client.nom } ${ client.telephone } a été enregistré dans la base.
		</span>
	</div>
</body>
</html>