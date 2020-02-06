<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.eclipse.utils.*"%>
<%@page import="org.eclipse.beans.Personne"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();
				out.print("<br>" + cks[i].getName() + " " + cks[i].getValue());
				if (name.equals("Auth")) {
					break; // exit the loop and continue the page
				}
				if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
				{
					response.sendRedirect("/jee-tp03-cookie/sessionExpired.html");
					return; // to stop further execution
				}
				i++;
			}
		} else {
			response.sendRedirect("/jee-tp03-cookie/sessionExpired.html");
			return; // to stop further execution
		}
	%>
	<div align="center">
		<h1>Bonjour ${username}</h1>
	</div>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>