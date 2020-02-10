<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<table border="0" cellpadding="3">
		<caption>
			<h2>Formulaire adresse</h2>
		</caption>
		<tr>
			<td><label for="rue">Rue *</label></td>
			<td><input type="text" id="rue" name="rue" value="${ rueSaisi }" /></td>
			<td><span class="erreur">${aform.erreurs['rue']}</span></td>
		</tr>
		<tr>
			<td><label for="codePostal">Code postal *</label></td>
			<td><input type="text" id="codePostal" name="codePostal" value="${ codePostalSaisi }" /></td>
			<td><span class="erreur">${aform.erreurs['codePostal']}</span></td>
		</tr>
		<tr>
			<td><label for="ville">Ville *</label></td>
			<td><input type="text" id="ville" name="ville" value="${ villeSaisi }" /></td>
			<td><span class="erreur">${aform.erreurs['ville']}</span></td>
		</tr>
	</table>	
</div>