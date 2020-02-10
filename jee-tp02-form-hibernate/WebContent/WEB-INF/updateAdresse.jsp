<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update d'une adresse</title>
</head>
<body>
	<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
	<jsp:directive.include file="linksListe.jsp" />
	<br>
	<form method="post" action="updateAdresse">
		<div align="center">
			<h2>Update adresse</h2>
			<table>
				<tr>
					<td><label for="id">Adresse ID *</label></td>
					<td><input type="text" id="id" name="id" value="${ idSaisi }" /></td>
					<td><span class="erreur">${aform.erreurs['id']}</span></td>
				</tr>
			</table>
		</div>
		<c:import url="formulaireAdresse.jsp"></c:import>
		<br>
		<div align="center"><input type="submit" value="Update" /></div>
	</form>
</body>
</html>