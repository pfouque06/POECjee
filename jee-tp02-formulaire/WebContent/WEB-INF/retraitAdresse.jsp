<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait d'une adresse</title>
</head>
<body>
<jsp:directive.include file="forEachAdresses.jsp" />
<br>
<form method="post" action="retraitAdresse">
<div> Formulaire de retrait d'une adresse</div>
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