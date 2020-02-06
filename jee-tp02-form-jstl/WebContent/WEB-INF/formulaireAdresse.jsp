<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>Formulaire adresse</div>
<div>
	<label for="rue">Rue *</label>
	<input type="text" id="rue" name="rue" value="${ rueSaisi }" />
	<span class="erreur">${aform.erreurs['rue']}</span>
</div>
<div>
	<label for="codePostal">Code postal *</label>
	<input type="text" id="codePostal" name="codePostal" value="${ codePostalSaisi }" />
	<span class="erreur">${aform.erreurs['codePostal']}</span>
</div>
<div>
	<label for="ville">Ville *</label>
	<input type="text" id="ville" name="ville" value="${ villeSaisi }" />
	<span class="erreur">${aform.erreurs['ville']}</span>
</div>