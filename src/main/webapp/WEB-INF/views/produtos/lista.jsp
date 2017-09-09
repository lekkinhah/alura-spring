<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listagem de Produtos - Casa do Código</title>
</head>
<body>
	<h1>Lista de Produtos cadastrados</h1>
	<table>
		<tr>
			<td>Título</td>
			<td>Descrição</td>
			<td>Páginas</td>
		</tr>
		
		<c:forEach items="${produtos}" var="p">
			<tr>
				<td>${p.titulo}</td>
				<td>${p.descricao}</td>
				<td>${p.pagina}</td>
			</tr>	
		</c:forEach>	
	</table>


</body>
</html>