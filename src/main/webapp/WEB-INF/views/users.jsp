<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form action="/pizzaria/user" method="post">

		<input type="hidden" name="_method"
			value="${empty user.id? 'post' : 'put'}"> <input
			type="hidden" name="id" value="${user.id}">

		<div id="user-panel" class="panel panel-default" style="width: 40%">
			<div class="panel-heading">
				<h3 class="panel-title">
					<label class="control-label">Cadastro de User</label>
				</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						name="username" value="${user.username}">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="password" value="${user.password}">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Primeiro Nome"
						name="firstname" value="${user.firstname}">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Sobrenome"
						name="lastname" value="${user.lastname}">
				</div>
				<button type="submit" class="btn btn-default">Salvar</button>
			</div>
		</div>
	</form>

	<table class="table table-striped table-bordered">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Nome</th>
			<th colspan="2" style="width: 10%;">OPÇÕES</th>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.firstname}&nbsp;${u.lastname}</td>
				<td><a href="/pizzaria/user/${u.id}">
						<button type="button" class="btn btn-info btn-xs"
							aria-label="Editar">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Editar
						</button>
				</a></td>
				<td>
					<form action="/pizzaria/user/${u.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-danger btn-xs"
							aria-label="Excluir">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							Excluir
						</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>