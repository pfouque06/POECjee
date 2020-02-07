<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des cients</title>
</head>
<body>
nombre de clients : ${ clientsSize } <br>
Clients :<br>
<c:forEach var="i" begin="0" end="${ clientsSize }" step="1">
   ${ clients[i].num } ${ clients[i].nom } ${ clients[i].prenom } ${ clients[i].telephone }<br>
</c:forEach>
</body>
</html>