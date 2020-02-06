<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>Formulaire client</div>
<div>
	<label for="nom">Nom *</label>
	<input type="text" id="nom" name="nom" value="${ nomSaisi }" />
	<span class="erreur">${cform.erreurs['nom']}</span>
</div>
<div>
	<label for="prenom">Prénom *</label>
	<input type="text" id="prenom" name="prenom" value="${ prenomSaisi }" />
	<span class="erreur">${cform.erreurs['prenom']}</span>
</div>
<div>
	<label for="telephone">Téléphone *</label>
	<input type="text" id="telephone" name="telephone" value="${ telephoneSaisi }" />
	<span class="erreur">${cform.erreurs['telephone']}</span>
</div>