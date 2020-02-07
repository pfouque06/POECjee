<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'une adresse</title>
</head>
<body>
<form method="post" action="creationAdresse">
<div> Formulaire d'ajout d'une adresse</div>
<div>
<label for="rue">Rue *</label>
<input type="text" id="rue" name="rue" value="" />
</div>
<div>
<label for="codePostal">Code postal *</label>
<input type="text" id="codePostal" name="codePostal" value="" />
</div>
<div>
<label for="ville">Ville *</label>
<input type="text" id="ville" name="ville" value="" />
</div>
<br>
<div> Formulaire client</div>
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
<input type="submit" value="Ajouter" />
</form>

<br>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<jsp:directive.include file="linksListe.jsp" />
</body>
</html>