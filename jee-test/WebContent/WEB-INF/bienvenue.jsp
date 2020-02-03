<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="refresh" content="1" > -->
<meta charset="UTF-8">
<title>BienvenueServlet</title>
</head>
<body>
Bienvenue au cours de programmation d'Andouillettes en barre

<%

// Set refresh, autoload time as 1 seconds
//response.setIntHeader("Refresh", 1);

out.println("<br/>");
int count = (int) request.getAttribute("count");
out.println("page invoquée " + count + " fois");

out.println("<br/>");
out.println("<br/>");

//request.setAttribute("today", today);
//String today = (String) request.getAttribute("today");
//SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//String today =  formater.format(new Date());
//out.println(today);

%>

<jsp:include page="/WEB-INF/Clock.jsp"></jsp:include>

</body>
</html>