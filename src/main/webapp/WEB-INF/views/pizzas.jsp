<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form action="/pizzaria/pizza" method="post">

		<input type="hidden" name="_method"
			value="${empty pizza.id? 'post' : 'put'}"> <input
			type="hidden" name="id" value="${pizza.id}">

		<div id="pizza-panel" class="panel panel-default" style="width: 40%">
			<div class="panel-heading">
				<h3 class="panel-title">
					<label class="control-label">Cadastro de Pizza</label>
				</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Pizza"
						name="name" value="${pizza.name}">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Preço"
						name="price" value="${pizza.price}">
				</div>
				<button type="submit" class="btn btn-default">Salvar</button>
			</div>
		</div>
	</form>

	<table class="table table-striped table-bordered">
		<tr>
			<th>ID</th>
			<th>Pizza</th>
			<th>Valor</th>
			<th colspan="2" style="width: 10%;">OPÇÕES</th>
		</tr>
		<c:forEach var="p" items="${pizzas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td><a href="/pizzaria/pizza/${p.id}">
						<button type="button" class="btn btn-info btn-xs"
							aria-label="Editar">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Editar
						</button>
				</a></td>
				<td>
					<form action="/pizzaria/pizza/${p.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-danger btn-xs"
							data-ng-click="deletePizza(pizza)" aria-label="Excluir">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							Excluir
						</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>