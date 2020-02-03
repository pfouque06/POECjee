<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BienvenueServlet</title>
</head>
<body>
Bienvenue au cours de programmation d'Andouillettes en barre

<%

out.println("<br/>");
int count = (int) request.getAttribute("count");
out.println("page invoquée " + count + " fois");

out.println("<br/>");
out.println("<br/>");
String today = (String) request.getAttribute("today");
out.println(today);

%>

</body>
</html>