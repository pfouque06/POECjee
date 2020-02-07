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
	nombre d'adresse : ${ adressesSize }
	<br> Adresses :
	<br>
	<c:forEach var="i" begin="0" end="${ adressesSize - 1 }" step="1">
- ${ adresses[i].num } ${ adresses[i].rue } ${ adresses[i].codePostal } ${ adresses[i].ville } ${ adresses[i].clientID } <br>
		<c:set var="result" value="false" />
		<c:forEach var="j" begin="0" end="${ clientsSize - 1 }" step="1">
			<%-- ${i}  ${j} ${adresses[i].clientID} ${clients[j].num}<br> --%>
			<c:if test="${adresses[i].clientID == clients[j].num}">
				<c:set var="result" value="true" />
    ## client : ${ clients[j].num } ${ clients[j].nom } ${ clients[j].prenom } ${ clients[j].telephone }<br>
			</c:if>
		</c:forEach>
		<c:if test="${result ne 'true'}">## client : aucun<br>
		</c:if>
		<br>
	</c:forEach>
</body>
</html>