<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<table border="0" cellpadding="3">
		<caption>
			<h2>Liste des clients</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Téléphone</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="client" items="${clients}">
			<tr>
				<td><c:out value="${client.id}" /></td>
				<td><c:out value="${client.nom}" /></td>
				<td><c:out value="${client.prenom}" /></td>
				<td><c:out value="${client.telephone}" /></td>
				<td>
					<a href="updateClient?id=<c:out value='${client.id}' />">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="deleteClient?id=<c:out value='${client.id}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	nombre de clients : ${ clientsSize }
	<br>
</div>

