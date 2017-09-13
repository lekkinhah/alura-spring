<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Produtos - Casa do Código</title>
</head>
<body>

	<form:form action="/casadocodigo/produtos" method="post" commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Título</label>
			<form:input path="titulo"/>
			<form:errors path="titulo" />
		</div>
		<div>
	        <label>Descrição</label>
	        <form:textarea path="descricao"/>
	        <form:errors path="descricao"/> 
	    </div>
	    <div>
	        <label>Páginas</label>
	        <form:input path="pagina"/>
	        <form:errors path="pagina" />
	    </div>
	    <div>
	    	<label>Data de Lançamento</label>
	    	<form:input path="dataLancamento"/>
	    	<form:errors path="dataLancamento" />
	    </div>
	    <div>
	    	<label>Sumário: </label>
	    	<input type="file" name="sumario">
	    </div>
	    <hr>
	    <h3>Cadastre os valores do produto</h3>
	    <c:forEach items="${tipos}" var="precos" varStatus="status">
	    	<div>
		        <label>${precos}</label>
		    	<form:input path="precos[${status.index}].valor"/>
		        <form:hidden path="precos[${status.index}].tipo" value="${precos}"/>
		    </div>
	    </c:forEach>
	    
	    <button type="submit">Cadastrar</button>	
	</form:form>

</body>
</html>