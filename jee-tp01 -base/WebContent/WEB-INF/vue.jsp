<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.eclipse.beans.*"%>
<%@ page import="java.util.ArrayList"%>
<!-- JSTL lib is auto loaded vua web.xml so following taglib is not required -->
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
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
		out.println("--- via scriplet ---<br/>");
		out.println("<br/>");

		//String thisURL = request.getRequestURL().toString();
		String thisURI = request.getRequestURI();
		String thisQuery = request.getQueryString();
		String thisUri = request.getContextPath();
		out.println("Ceci est la page " + thisURI + "/" + thisQuery + "<br>Le contexPath est " + thisUri);

		out.println("<br/>");

		String notreVille = (String) request.getAttribute("maVille");
		out.println("<br/>Bienvenue à " + notreVille);

		out.println("<br/>");

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		out.println("<br/>Hello (from Query)" + prenom + " " + nom);

		Personne perso1 = (Personne) request.getAttribute("perso1");

		if (perso1 != null)
			out.println("<br/>Hello perso1 (from servlet) : " + perso1.getPrenom() + " " + perso1.getNom());

		perso.setNom("Relax");
		perso.setPrenom("Max");

		out.println("<br/>Hello perso (embedded in scriplet): " + perso.getPrenom() + " " + perso.getNom());

		out.println("<br/>");

		ArrayList<String> sport = new ArrayList<>();

		out.println("<br/>");
	%>
	<br> --- via EL (Expression language) ---
	<br> Hello perso ${ perso.getPrenom()} ${ perso.nom}
	<br> ou ${ perso.prenom} ${ perso.getNom()}
	<br>
	<br> J'aime le ${sport.get(0) } et ${sport[3]}.
	<br> Je déteste le ${sport['1'] } et ${sport["2"]}.
	<br>
	<br> --- JSTL Library training ... ---
	<br>
	<c:out value="Hello World" />
	<br>
	<c:set var="JEE" value="Je love la plateforme JEE" scope="request" />
	<c:out value="${JEE}" />
	<br>
	<c:remove var="JEE" />
	<c:out value="${JEE}" />
	<!-- not displayed since var has been previously removed -->

	<br>
	<c:set var="x" value="${0}" />
	<c:set var="x" value="${x+1}" />
	<c:out value="${x}" />

	<br>
	<c:set scope="session" var="p" value="${perso1}" />
	<c:out value="${p}" />
	<!-- appelle la methode Personne.toString() -->
	<br>
	<c:out value="${p.nom} ${p.prenom}" />
	<br>
	<c:set target="${perso1}" property="nom" value="Travolta" />
	<c:out value="${p.nom} ${p.prenom}" />
	<br>
	<c:if test="${3>2 and 2>1 }">C'est facile</c:if>
	<br>
	<c:if test="${3>2 and 2>1}" var="result" />
	C'est facile :
	<c:out value="${result}" />
	<br>
	<br>
	<c:choose>
		<c:when test="${3>2 and 2>1 }">C'est facile</c:when>
		<c:otherwise>actions par défault</c:otherwise>
	</c:choose>
	<br>
	<br>
	<c:forEach var="i" begin="0" end="10" step="1">
		<c:out value="${i}" /> <!-- result: 0 1 2 3 4 5 6 7 8 9 10 -->
	</c:forEach>
	<c:forEach var="i" items="${data }">
		<c:out value="${i.nom}" /> <!-- 0 1 2 3 4 5 6 7 8 9 10 -->
	</c:forEach>
	<br>
	<br>
	<c:forTokens var="subString" delims=";, " items="bonjour, c'est John;Wick">
		<c:out value="${subString}" /> <!-- result: bonjour c'est John Wick -->
	</c:forTokens>
	<br>
	<br>
	<c:url var="lien01" value="/mapage" />
	<a href="${lien01 }" >>lien01</a>
	<br>
	<c:url var="lien02" value="/ajoutPersonne3" />
	<a href="${lien02 }" target="_blank" >>lien02</a>
	<br>
	<br>
	<c:import url="/ajoutPersonne3" />
	<br>
	<br>
	<c:import url="/WEB-INF/ajoutPersonne3.jsp" />
	<br>
	<br>
	${fn:length("chaine")} <!-- retourne 6 -->
	<br>
	${fn:contains("Bonjour","bon")} <!-- retourne false -->
	<br>
	
	
</body>
</html>