<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des clients</title>
</head>
<body>
<jsp:directive.include file="forEachClients.jsp" />
<br>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<jsp:directive.include file="linksListe.jsp" />
</body>
</html>