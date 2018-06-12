<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Selecionando itens</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Produtos disponíveis:</h2>
		<form  action="Listar" method="GET">
			<c:forEach items="${requestScope.produtos}" var="produto">
				<div class="checkbox">
					<label><input type="checkbox" name="selecionado" value="${produto.produtoId}">${produto.nome} 
					<fmt:formatNumber value = "${produto.preco}" type = "currency"/></label>
				</div>
			</c:forEach>
		<button type="submit" class="btn btn-default">Comprar</button>
		</form>
	</div>
</body>
</html>