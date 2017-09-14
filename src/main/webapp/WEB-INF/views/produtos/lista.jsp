<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listagem de Produtos - Casa do Código</title>
</head>
<body>
	<h1>Lista de Produtos cadastrados</h1>
	<h3>${sucesso}</h3>
	<table>
		<tr>
			<td>Título</td>
			<td>Descrição</td>
			<td>Páginas</td>
			<td> </td>
		</tr>
		
		<c:forEach items="${produtos}" var="p">
			<tr>
				<td>${p.titulo}</td>
				<td>${p.descricao}</td>
				<td>${p.pagina}</td>
				<td><a href="produtos/detalhe/${p.id}">Exibir detalhes</a></td>
			</tr>	
		</c:forEach>	
	</table>


</body>
</html>