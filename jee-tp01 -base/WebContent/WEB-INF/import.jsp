<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import var="web" url="file:/C:/Users/Admin/Desktop/POEC_Java/sources/gitlab/jee-cours01/WebContent/WEB-INF/web.xml" />
<c:import var="web2" url="WEB-INF/web.xml" />
<x:parse xml="${web }" var="list" />
</body>
</html>