<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<table border="0" cellpadding="3">
		<caption>
			<h2>Formulaire client</h2>
		</caption>
		<tr>
			<td><label for="nom">Nom *</label></td>
			<td><input type="text" id="nom" name="nom" value="${ nomSaisi }" /></td>
			<td><span class="erreur">${cform.erreurs['nom']}</span></td>
		</tr>
		<tr>
			<td><label for="prenom">Prénom *</label></td>
			<td><input type="text" id="prenom" name="prenom" value="${ prenomSaisi }" /></td>
			<td><span class="erreur">${cform.erreurs['prenom']}</span></td>
		</tr>
		<tr>
			<td><label for="telephone">Téléphone *</label></td>
			<td><input type="text" id="telephone" name="telephone" value="${ telephoneSaisi }" /></td>
			<td><span class="erreur">${cform.erreurs['telephone']}</span></td>
		</tr>
	</table>	
</div>