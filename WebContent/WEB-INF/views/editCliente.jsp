<%@page import="unoesc.edu.aulaJSP.model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit de cliente</title>
</head>
<body>
	<%
		ArrayList<Cliente> listaCliente;
  
  		if (session.getAttribute("listaCliente") == null)
  			listaCliente = new ArrayList();
  		else 
  			listaCliente = (ArrayList) session.getAttribute("listaCliente");
  		
  		System.out.print("\n-> "+ request.getParameter("minhaVariavel")+ "\n\n");
  		int indexClienteParaEditar = Integer.valueOf(request.getParameter("minhaVariavel")); //pegando o parametro
  		Cliente c = listaCliente.get(indexClienteParaEditar); //pegando o cliente a ser editado.
  		
  	 %>
	
	<form action="manipulaCliente" method="post">
		<p>Nome: <input type="text" name="nome" value="<%= c.getNome() %>"></p>
		<p>Sobrenome: <input type="text" name="sobrenome" value=<%= c.getSobrenome()%> ></p>
		
		<input type="hidden" name="indice" value="<%= indexClienteParaEditar%>">
		<input type="submit">
	</form>


</body>
</html>