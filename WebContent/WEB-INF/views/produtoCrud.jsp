<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listClientas.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Nome</th>
					<th>Marca</th>
					<th>Preço</th>
				</tr>
				<c:forEach var="c" items="${listClientas}">
					<tr>
						<td>${c.name}</td>
						<td>${c.brand}</td>
						<td>${c.valor}</td>
<%-- 						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dataNasc}"/></td> --%>
						<td><a href="/aulaJSP/produtoEdit/${c.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		 Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao
				<form action="/aulaJSP/produtoSave" method="POST" modelAttribute="produto">
					<form:hidden path="produto.id" />
					<p>
						Nome:
						<form:input path="produto.name" />

					</p>

					<p>
						Marca:
						<form:input path="produto.brand" />

					</p>
					<p>
						Preço:
						<form:input path="produto.valor" />

					</p>
					<p>
						Detalhes:
						<form:input path="produto.detail" />

					</p>
					

					<input type="submit" value="Salvar" />

				</form>
			</div>


		<a href="/aulaJSP"> voltar</a>
</body>
</html>