<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait d'une adresse</title>
</head>
<body>
L'adresse ${ adresse.num } ${ adresse.rue } ${ adresse.codePostal } ${ adresse.ville } a été retirée de la base.
<br>
<br>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<jsp:directive.include file="linksListe.jsp" />
</body>
</html>