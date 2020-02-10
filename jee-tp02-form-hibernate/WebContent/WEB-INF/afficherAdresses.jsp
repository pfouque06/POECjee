<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des adresses</title>
</head>
<body>
<%-- <jsp:include page="/WEB-INF/linksListe.jsp"></jsp:include> --%>
<%-- <jsp:directive.include file="linksListe.jsp" /> --%>
<c:import url="linksListe.jsp"></c:import>
<br>
<jsp:directive.include file="forEachAdresses.jsp" />
</body>
</html>