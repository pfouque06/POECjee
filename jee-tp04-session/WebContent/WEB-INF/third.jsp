<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.eclipse.utils.*"%>
<%@page import="org.eclipse.beans.Personne"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Third page</title>
</head>
<body>
<%-- 	<%
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
					response.sendRedirect("/jee-tp04-session/sessionExpired.html");
					return; // to stop further execution
				}
				i++;
			}
		} else {
			response.sendRedirect("/jee-tp04-session/sessionExpired.html");
			return; // to stop further execution
		}
	%> --%>
	<div align="center">
		<h1>Third page</h1>
		<h2>Bonjour ${username}</h2>
		<table border="0" cellpadding="3">
			<tr>
				<td><a href="first">First page</a></td>
				<td><a href="second">Second page</a></td>
				<td><a href="third">Third page</a></td>
			</tr>
		</table>
		<form action="logout" method="post">
			<input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>