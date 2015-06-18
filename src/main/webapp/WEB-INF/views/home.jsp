<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped table-bordered">
	<tr>
		<th>ID</th>
		<th>Pizza</th>
		<th>Valor</th>
	</tr>
	<c:forEach var="p" items="${pizzas}">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
		</tr>
	</c:forEach>
</table>