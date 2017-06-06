<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="icon" type="image/png"
	href="http://www.salaire-brut-en-net.fr/wp-content/uploads/favicon2.png" />
<title>SGP - App</title>
</head>
<body>


	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Mettre un titre</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/paie/mvc/employes/creer">Ajout Employé</a></li>
					<li><a href="/paie/mvc/employes/lister">Liste Emloyé</a></li>
					<li><a href="/paie/mvc/bulletins/lister">Ajout Bulletin</a></li>
					<li><a href="/paie/mvc/bulletins/lister">Liste Bulletin</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<div>
		<h1>Liste Des Employés</h1>
		<table class="table table-bordered">
			<thead align="center">
				<td>Date/heure creation</td>
				<td>Matricule</td>
				<td>Grade</td>
			</thead>
			<tbody align="center">
				<c:forEach var="employes" items="${employes}">
					<td>${employes.dateForm()}</td>
					<td>${employes.matricule}</td>
					<td>${employes.grade.code}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>