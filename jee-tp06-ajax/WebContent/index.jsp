<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
	<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br>
	<br>
	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
	<br>
	<br>
	<button id="ajaxButton" type="button">Faire une requête</button>
	<script>
		(function() {
			var httpRequest;
			document.getElementById("ajaxButton").addEventListener('click', makeRequest);
			
			function makeRequest() {
				httpRequest = new XMLHttpRequest();
				if (!httpRequest) {
					alert('Abandon :( Impossible de créer une instance de XMLHTTP');
					return false;
				}
				httpRequest.onreadystatechange = alertContents;
				httpRequest.open('GET', 'test.html');
				httpRequest.send();
			}
			
			function alertContents() {
				if (httpRequest.readyState === XMLHttpRequest.DONE) {
					if (httpRequest.status === 200) {
						alert(httpRequest.responseText);
					} else {
						alert('Il y a eu un problème avec la requête.');
					}
				}
			}
		})();
	</script>
</body>
</html>