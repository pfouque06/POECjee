<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update d'un client</title>
</head>
<body>
<jsp:directive.include file="forEachClients.jsp" />
<br>
<form method="post" action="updateClient">
<div> Formulaire d'update d'un client</div>
<div>
<label for="num">son numéro *</label>
<input type="text" id="num" name="num" value="" />
</div>
<div>
<label for="nom">Nom *</label>
<input type="text" id="nom" name="nom" value="" />
</div>
<div>
<label for="prenom">Prénom *</label>
<input type="text" id="prenom" name="prenom" value="" />
</div>
<div>
<label for="telephone">Téléphone *</label>
<input type="text" id="telephone" name="telephone" value="" />
</div>
<input type="submit" value="Update" />
</form>

<br>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<jsp:directive.include file="linksListe.jsp" />
</html>