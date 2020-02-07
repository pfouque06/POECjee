<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<div align="center">
	<table border="0"  cellpadding="3">
		<caption>
			<h2>Liste des adresses</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Rue</th>
			<th>Code postale</th>
			<th>Ville</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Téléphone</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="adresse" items="${adresses }">
		
			<tr>
				<td><c:out value="${adresse.num}" /></td>
				<td><c:out value="${adresse.rue}" /></td>
				<td><c:out value="${adresse.codePostal}" /></td>
				<td><c:out value="${adresse.ville}" /></td>

				<c:set var="result" value="false" />
				<c:forEach var="client" items="${clients}">
					<c:if test="${adresse.clientID == client.num}">
						<c:set var="result" value="true" />
						<td><c:out value="${client.nom}" /></td>
						<td><c:out value="${client.prenom}" /></td>
						<td><c:out value="${client.telephone}" /></td>
					</c:if>
				</c:forEach>
				<c:if test="${result ne 'true'}">
					<td></td>
					<td></td>
					<td></td>
				</c:if>
				<td>
					<a href="updateAdresse?id=<c:out value='${adresse.num}' />">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="deleteAdresse?id=<c:out value='${adresse.num}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	nombre d'adresses : ${ adressesSize }
	<br>
</div>
