<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>projet Andouillettes</title>
</head>
<body>
	<%
	for (int i= 1; i<=5; i++)
		out.println("J'aime les andouilletes !!<br>");
	
	out.println("<br/>");
	
	String today = (String) request.getAttribute("today");
	out.println(today);
	
	out.println("<br/>");
	out.println("<br/>");
	
	out.println("Printemps<br>");
	out.println("Eté<br>");
	out.println("Autonme<br>");
	out.println("Hiver<br>");	
	%>
	
</body>
</html>