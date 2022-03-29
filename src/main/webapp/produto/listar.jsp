<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
</head>
<body>
    <div align="center">
		<h1>Produtos</h1>
		<h2>
			<a href="inserir">Inserir Novo Produto</a>
		</h2>
	</div>
	<div align="center">
		<form action="listar" method="GET">
			Nome: <input type="text" name="nome" id="nome">
			<input type="submit" value="Pesquisar">
		</form>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>Lista de Produtos</h2></caption>
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Preço</th>
				<th>Categoria</th>
			</tr>
			<c:forEach var="produto" items="${listaProduto}">
				<tr>
					<td><c:out value="${produto.id}" /></td>
					<td><c:out value="${produto.nome}" /></td>
					<td><c:out value="${produto.preco}" /></td>
					<td><c:out value="${produto.categoria.nome}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%--	<a href="../index.jsp"> Voltar </a>	--%>
</body>
</html>