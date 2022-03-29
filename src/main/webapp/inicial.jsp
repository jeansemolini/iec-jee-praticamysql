<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
</head>
<body>
	<div align="center">
		<h1>Categorias de Despesas</h1>
        <h2>
        	<a href="categoria/inserir.jsp">Inserir Nova Categoria</a><br />
            <a href="produto/inserir">Inserir Novo Produto</a>
        </h2>
	</div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Categorias</h2></caption>
            <tr>
                <th>Codigo</th>
                <th>Nome</th>
                <th>Acoes</th>                              
            </tr>
            <c:forEach var="categoria" items="${listaCategoria}">
                <tr>
                    <td><c:out value="${categoria.codigo}" /></td>
                    <td><c:out value="${categoria.nome}" /></td>

                    <td>
                    	<a href="categoria/edit?id=<c:out value='${categoria.codigo}' />">Alterar</a>
                    		&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="categoria/delete?id=<c:out value='${categoria.codigo}' />">Deletar</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="produto/listar?categoria_id=<c:out value='${categoria.codigo}' />">Listar Produtos</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>