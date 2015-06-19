<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/pizzaria/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="/pizzaria/resources/css/pizzaria.css"
	type="text/css">
<title>Pizzaria Spring</title>
</head>

<body>
	<div id="all" class="jumbotron">
		<div id="menu">
			<ul>
				<li><a href="/pizzaria">HOME</a></li>
					<li><a href="/pizzaria/user">USUÁRIOS</a></li>

					<li><a href="/pizzaria/pizza">PIZZAS</a></li>

					<li><a href="/pizzaria/logout">LOGOUT</a></li>

					<li><a href="/pizzaria/login">LOGIN</a></li>
			</ul>
		</div>
		<div id="header">
			<h1>Pizzaria Spring</h1>
		</div>
		<div id="content">
			<jsp:include page="${pagePath}" />
		</div>
	</div>
</body>
</html>