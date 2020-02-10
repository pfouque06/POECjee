<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait d'un client</title>
</head>
<body>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
	<br>
	<div align="center">
		<h2>Retrait client</h2>
		<span>
		Le client ${ client.prenom } ${ client.nom } ${ client.telephone } a bien été retiré de la base.
		</span>
	</div>
</body>
</html>