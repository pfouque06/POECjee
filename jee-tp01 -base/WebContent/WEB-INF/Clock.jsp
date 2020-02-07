<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<meta http-equiv="refresh" content="1" >
<%
// Set refresh, autoload time as 1 seconds
//response.setIntHeader("Refresh", 1);

SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
String today =  formater.format(new Date());
out.println(today);
%>
