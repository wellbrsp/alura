<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem-vindo</title>
</head>
<body>
	<% String msg = "Primeiro JSP"; %>
	<br />
	<% out.println(msg); %>
	<br />
	<% String msg2 = "ok!";  %>
	<br />
	<%=msg2 %>
	<br />
	<% System.out.println("Tudo ok!"); %>
	

</body>
</html>