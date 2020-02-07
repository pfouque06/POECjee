<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'une personne</title>
</head>
<body>
<form method="post" action="ajoutPersonne1">
<div> Formulaire d'ajout d'une Personne</div>
<div>
<label for="nom">Nom *</label>
<input type="text" id="nom" name="nom" value="${ nomSaisi }"/>
${ nomIncorrect }
</div>
<div>
<label for="prenom">Prénom *</label>
<input type="text" id="prenom" name="prenom" value="${ prenomSaisi }" />
${ prenomIncorrect }
</div>
<input type="submit" value="Ajouter" />
</form>
</body>
</html>