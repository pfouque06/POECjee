VUE_FORM<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait d'une adresse</title>
</head>
<body>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
	<br>
	<div align="center">
		<h2>Retrait adresse</h2>
		<span>
		L'adresse ${ adresse.id } ${ adresse.rue } ${ adresse.codePostal } ${ adresse.ville } a bien été retiré de la base.
		</span>
	</div>
</body>
</html>