<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*,
    	br.com.alura.dao.*,
    	br.com.alura.model.*"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
	
	<table>
		<%
		ContatoDao dao = new ContatoDao();
		List<Contato> listaContatos = dao.getListaContato();
		
		for (Contato c : listaContatos) {
		 %>
			<tr>	
				<td><%=c.getNome() %>  </td>
				<td><%=c.getEmail() %>  </td>
				<td><%=c.getEndereco() %>  </td>
				<td><%=c.getDataNascimento().getTime() %>  </td>
			</tr>	
		<% 			
		}
		%>			
	</table>
	
</body>
</html>