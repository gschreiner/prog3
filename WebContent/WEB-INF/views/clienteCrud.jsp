<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listClientes.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Nome</th>
					<th>sobrenome</th>
					<th>Data</th>
				</tr>
				<c:forEach var="c" items="${listClientes}">
					<tr>
						<td>${c.nome}</td>
						<td>${c.sobrenome}</td>
						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dataNasc}"/></td>
						<td><a href="clienteEdit/${c.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		 Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao
				<form action="/aulaJSP/clienteSave" method="POST" modelAttribute="cliente">
					<form:hidden path="cliente.id" />
					<p>
						Nome:
						<form:input path="cliente.nome" />

					</p>

					<p>
						E-Mail:
						<form:input path="cliente.sobrenome" />

					</p>
					
					<p>
					teste: 
						<form:input type="date" path="cliente.dataNasc" />

					</p>

					<input type="submit" value="Salvar" />

				</form>
			</div>


		<a href="/aulaJSP"> voltar</a>
</body>
</html>