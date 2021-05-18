<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedidos</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listPedidos.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Data</th>
					<th>Marca</th>
					<th>Options</th>
				</tr>
				<c:forEach var="c" items="${listPedidos}">
					<tr>
 						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.data}"/></td>
						<td>${c.cliente.nome}</td>
						<td>
							<a href="/aulaJSP/pedidoEdit/${c.id}">Edit</a>
							<a href="/aulaJSP/pedidoEditItens/${c.id}">Edit Itens</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		 Dados do Pedido
				<form action="/aulaJSP/pedidoSave" method="POST" modelAttribute="pedido">
						<form:hidden path="pedido.id" />
					
						<form:label path="pedido.data">Data</form:label>
						<form:input type="date" path="pedido.data" style="margin-right:80px;" />
						
						<form:label path="pedido.faturado">Faturado</form:label>
						<form:checkbox path="pedido.faturado" style="margin-right:20px;"/>

						<form:label path="pedido.entregue">Pedido</form:label>
						<form:checkbox path="pedido.entregue" />

					
					<p>
						<form:label path="pedido.cliente">Cliente</form:label>
						<form:select path="pedido.cliente.id">
                    		<form:option value="-1" label="--Selecione Cliente"/>
                    		<form:options items="${listClientes}" itemValue="id" itemLabel="nome"/>
                		</form:select>

					</p>
					
					
					
						<input type="submit" value="Adicionar Pedido" />
					</form>
					
					

				
			</div>


		<a href="/aulaJSP"> voltar</a>
</body>
</html>