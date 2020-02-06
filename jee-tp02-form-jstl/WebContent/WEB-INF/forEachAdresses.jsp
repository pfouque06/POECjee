<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des adresses</title>
</head>
<body>
	Adresses :
	<br>
	<c:forEach items="${adresses }" var="adresse">
		<c:out
			value="- [${adresse.num }] ${adresse.rue } ${ adresse.codePostal } ${ adresse.ville }" />
		<br>
		<c:set var="result" value="false" />

		<c:forEach items="${clients }" var="client">
			<c:if test="${adresse.clientID == client.num}">
				<c:set var="result" value="true" />
				<c:out
					value="## [${client.num }] ${client.nom } ${ client.prenom } ${ client.telephone }" />
				<br>
			</c:if>
		</c:forEach>

		<c:if test="${result ne 'true'}">## aucun client !! <br>
		</c:if>
		<br>
	</c:forEach>

	<br> nombre d'adresses : ${ adressesSize }
	<br>
</body>
</html>