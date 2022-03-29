<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir Produto</title>
</head>
<body>
    <center>
		<h1>Inserir Produto</h1>
		<form action="inserir" method="POST">
			Nome: <input type="text" name="nome" id="nome"><br />
			Preço: <input type=number step=0.01 min="0" name="preco" id="preco"><br />
			Categoria: <select name="categoria">
				<c:forEach items="${listaCategoria}" var="categoria">
					<option value="${categoria.codigo}"><c:out value="${categoria.nome}" /></option>
				</c:forEach>
			</select>
			<input type="submit" value="Inserir">
		</form>
		<a href="../index.jsp"> Voltar </a>
	</center>
</body>
</html>