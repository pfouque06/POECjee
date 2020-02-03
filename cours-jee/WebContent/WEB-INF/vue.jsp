<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "org.eclipse.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>projet JEE</title>
</head>
<body>
Hello World (depuis une JSP) siouplé
	<jsp:useBean id="perso" scope="page" class="org.eclipse.beans.Personne">
	</jsp:useBean>
	<%
out.println("<br/>");

//String thisURL = request.getRequestURL().toString();
String thisURI = request.getRequestURI();
String thisQuery = request.getQueryString();
String thisUri = request.getContextPath();
out.println("<br/>Ceci est la page " + thisURI +"/" + thisQuery +  "<br>Le contexPath est " + thisUri);

out.println("<br/>");

String notreVille = (String) request.getAttribute("maVille");
out.println("<br/>Bienvenue à " + notreVille);

out.println("<br/>");

String nom = request.getParameter("nom");
String prenom = request.getParameter("prenom");
out.println("<br/>Hello (from Query)" + prenom + " " + nom);

Personne perso1 = (Personne) request.getAttribute("perso1");

if (perso1 != null )
	out.println("<br/>Hello perso1 (from servlet) : " + perso1.getPrenom() + " " + perso1.getNom());

perso.setNom("Relax");
perso.setPrenom("Max");

out.println("<br/>Hello perso (embedded in scriplet): " + perso.getPrenom() + " " + perso.getNom());

out.println("<br/>");
%>
via EL (Expression language)
<br>
Hello perso  ${ perso.getPrenom()} ${ perso.nom}
<br>
ou ${ perso.prenom} ${ perso.getNom()}

</body>
</html>