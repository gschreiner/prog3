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
		 Dados do Pedido
				<form action="/aulaJSP/addPedido" method="POST" modelAttribute="pedido">
						<form:hidden path="pedido.id" />
					
						<form:label path="pedido.data">Data</form:label>
						<form:input type="date" path="pedido.data" style="margin-right:80px;" readonly="readonly"/>
						
						<form:label path="pedido.faturado">Faturado</form:label>
						<form:checkbox path="pedido.faturado" style="margin-right:20px;" readonly="readonly"/>

						<form:label path="pedido.entregue">Pedido</form:label>
						<form:checkbox path="pedido.entregue" readonly="readonly" />

					
					<p>
						<form:label path="pedido.cliente">Cliente</form:label>
						<form:select path="pedido.cliente.id" readonly="readonly">
                    		<form:option value="-1" label="--Selecione Cliente"/>
                    		<form:options items="${listClientes}" itemValue="id" itemLabel="nome"/>
                		</form:select>

					</p>
					
					Itens do Pedido:
					<c:if test="${pedido.items.size() > 0}">
						<table border="2" width="70%" cellpadding="2">
							<tr>
								<th>Item</th>
								<th>Preço</th>
								<th>Quantidade</th>
							</tr>
							<c:forEach var="p" items="${pedido.items}">
								<tr>
			 						<td>${p.produto.name}</td>
									<td>${p.valor}</td>
									<td>${p.qt}</td>
<%-- 									<td><a href="/aulaJSP/pedidoEdit/${c.id}">Edit</a></td> --%>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					
						<form:label path="itemPedido.produto">Cliente</form:label>
						<form:select path="itemPedido.produto.id">
                    		<form:option value="-1" label="--Selecione Produto"/>
                    		<form:options items="${listProdutos}" itemValue="id" itemLabel="name"/>
                    		
                    		<form:label path="itemPedido.valor">Preco</form:label>
							<form:input path="itemPedido.valor" style="margin-right:80px;" />
							<form:label path="itemPedido.qt">Quantidade</form:label>
							<form:input path="itemPedido.qt" style="margin-right:80px;" />	
                		</form:select>
					
						<input type="submit" value="Adicionar no Pedido" />
					</form>
					
					

				
			</div>


		<a href="/aulaJSP"> voltar</a>
</body>
</html>