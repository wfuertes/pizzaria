<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Treinamento Spring Framework: Controller e View</title>
</head>
<body>
	<h3>Exemplo de View JSP + Controller Spring MVC.</h3>
	<a href="/pizzaria">Home</a>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>PREÇO</th>
		</tr>
		<c:forEach var="p" items="${pizzas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>