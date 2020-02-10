<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP Formulaire</title>
</head>
<body>
	<c:if test="${ username == null }" >
		<c:import url="/WEB-INF/login.jsp" />
	</c:if>
	<c:if test="${ username != null }" >
		<c:import url="/WEB-INF/linksListe.jsp" />
	</c:if>
	<%-- 
	<c:choose>
		<c:when test="${ username != null }">
			<c:import url="/WEB-INF/linksListe.jsp" />
			<c:import url="/WEB-INF/logout.jsp" />
		</c:when>
		<c:otherwise>
			<c:import url="/WEB-INF/login.jsp" />
		</c:otherwise>
		<br>
	</c:choose>
	 --%>
</body>
</html>