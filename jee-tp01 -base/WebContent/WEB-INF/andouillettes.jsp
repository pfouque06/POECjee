<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Date" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>projet Andouillettes</title>
</head>
<body>
	<%
	//for (int i= 1; i<=5; i++)
	//	out.println("J'aime les andouilletes !!<br>");
	
	out.println("<br/>");
	
	//String today = (String) request.getAttribute("today");
	//out.println(today + "<br/>");
	
	out.println("<br/>");
	
	//out.println("Printemps<br>");
	//out.println("Eté<br>");
	//out.println("Autonme<br>");
	//out.println("Hiver<br>");
	
	%>
	<c:forEach var="i" begin="1" end="5" step="1">
    <p>J'aime les andouillettes !!<c:out value="${ i }" /><br></p>
	</c:forEach>
	
	${today}<br>
	<br>
	${ saisons[0] }<br>
	${ saisons[1] }<br>
	${ saisons[2] }<br>
	${ saisons[3] }<br>
	
</body>
</html>