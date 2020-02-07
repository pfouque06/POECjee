<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Personnes</title>
</head>
<body>
nombre de Personnes : ${ personnesSize } <br>
Listes :<br>

<c:forEach var="i" begin="0" end="${ personnesSize }" step="1">
   ${ personnes[i].num } ${ personnes[i].nom } ${ personnes[i].prenom }<br>
</c:forEach>

<br>
</body>
</html>