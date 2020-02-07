<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait d'un client</title>
</head>
<body>
<jsp:directive.include file="forEachClients.jsp" />
<br>
<form method="post" action="retraitClient">
<div> Formulaire de retrait d'un client</div>
<div>
<label for="num">son numéro *</label>
<input type="text" id="num" name="num" value="" />
</div>
<input type="submit" value="Retirer" />
</form>

<br>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<jsp:directive.include file="linksListe.jsp" />
</body>
</html>