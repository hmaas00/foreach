<%-- 
    Document   : lista
    Created on : 07/05/2018, 21:59:22
    Author     : Rafael.Soares
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compras do período</title>
<style>
.vermelho {
	color: red;
}
</style>
</head>
<body>
	<h1>Compras</h1>
	<fmt:setLocale value = "pt_BR"/>
	<c:forEach items="${requestScope.compras}" var="compra">
		<h3>
			Data compra:
			<fmt:formatDate value="${compra.data.time }"
				pattern="dd-MMM-yyyy HH:mm:ss" />
		</h3>
		<table border="1px">
			<thead>
				<th>nome</th>
				<th>preco</th>
			</thead>
			<tbody>
				<c:forEach items="${compra.produtos}" var="prod">
					<tr
						<c:if test="${prod.promo == true}">
                           class="vermelho"
                        </c:if>>
						<td>${prod.nome}</td>
						<td><fmt:formatNumber value = "${prod.preco}" type = "currency"/></td>
					</tr>
				</c:forEach>
				<tr>
					<td>total:</td>
					<td><fmt:formatNumber value = "${compra.vlrTotal }" type = "currency"/></td>
				</tr>

			</tbody>
		</table>
	</c:forEach>
</body>
</html>