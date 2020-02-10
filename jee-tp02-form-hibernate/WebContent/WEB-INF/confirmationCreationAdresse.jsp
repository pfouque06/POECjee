<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'une adresse</title>
</head>
<body>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
	<br>
	<div align="center">
		<h2>Formulaire adresse</h2>
		<span>
			L'adresse ${ adresse.id } ${ adresse.rue } ${ adresse.codePostal } ${ adresse.ville } a été enregistré dans la base.<br>
			<br>
			<c:choose>
				<c:when test="${ adresse.clientID >= 0 }">
				Le client associé ${ client.id } ${ client.prenom } ${ client.nom } ${ client.telephone } a aussi été enregistré dans la base.
				</c:when>
				<c:otherwise>
				Erreur - Vous n'avez pas rempli tous les champs obligatoires pour la création du client.<br>
				Le client n'a pu être enregistré dans la base.
				</c:otherwise>
			</c:choose>
		</span>
	</div>
</body>
</html>