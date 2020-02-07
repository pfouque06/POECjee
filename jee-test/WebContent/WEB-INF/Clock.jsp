<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<meta http-equiv="refresh" content=60 >
<%
// Set refresh, autoload time as 1 seconds
//response.setIntHeader("Refresh", 10);

SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
String today =  formater.format(new Date());
out.println(today);
%>
