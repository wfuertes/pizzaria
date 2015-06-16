<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Treinamento Spring Framework: Controller e View</title>
<style type="text/css">
.delete-link {
	background: none;
	border: none;
	color: blue;
	text-decoration: underline;
	cursor: pointer;
}
</style>
</head>
<body>
	<h3>Exemplo de View JSP + Controller Spring MVC.</h3>
	<a href="/pizzaria">Home</a>
	<form action="/pizzaria/logout" method="post">
		<input type="submit" value="Logout">
	</form>

	<form action="/pizzaria/pizza" method="post">
		<input type="hidden" name="_method"
			value="${empty pizza.id? 'post' : 'put'}"> <input
			type="hidden" name="id" value="${pizza.id}"> <br> <label>Pizza:</label>
		<input type="text" name="name" value="${pizza.name}"> <br>

		<label>Valor:</label> <input type="text" name="price"
			value="${pizza.price}"> <br> <input type="submit"
			value="Salvar">
	</form>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>PREÇO</th>
			<th colspan="2">OPÇÕES</th>
		</tr>
		<c:forEach var="p" items="${pizzas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td><a href="/pizzaria/pizza/${p.id}">Editar</a></td>
				<td>
					<form action="/pizzaria/pizza/${p.id}" method="post">
						<input type="hidden" name="_method" value="delete"> <input
							class="delete-link" type="submit" value="Excluir">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>