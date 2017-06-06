<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/js/bootstrap.js'></c:url>">
<title>SGP - créer Employer</title>
</head>
<body class="container junbotron">

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
				<a class="navbar-brand" href="lister">Pro RH</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/paie/index.html">Home</a></li>
					<li><a href="/paie/mvc/employes/lister">Employes</a></li>
					<li class="active"><a href="activites">Activités</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	
	<br>
	<br>
	<br>
	<a href="/paie/mvc/bulletins/lister" type="button"
		class="btn btn-sm btn-warning"><span class="glyphicon glyphicon-plus"></span> lister bulletin</a>
	<br>
	<br>
	<br>
	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Ajouter un employé</legend>

			<!-- Select Basic Periode -->

			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Periode</label>
				<div class="col-md-4">
					<select id="Entreprise" name="periode" class="form-control">
						<c:forEach var="periode" items="${listPeriodes}">
							<option value="${periode.id}">${periode.dateDebut}</option>
						</c:forEach>
					</select>
					<!-- </select> -->
				</div>
			</div>

			<!-- Select Basic Matricule -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Matricule ${listEmploye}</label>
				<div class="col-md-4">
					<select id="Matricule" name="matricule" class="listeProfil">
						<c:forEach var="matricule" items="${listEmploye}">
							<option value="${matricule.id}">${matricule.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Text input Prime Exceptionnelle-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Prime
					Exceptionnelle</label>
				<div class="col-md-4">
					<input id="matricule" name="matricule" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>




			<!-- Button -->
			<div class="form-group">
				<div class="col-md-4">
					<button id="buttonAddEmploye" name="buttonAddEmploye"
						class="btn btn-default">Ajouter</button>
				</div>
			</div>

		</fieldset>
	</form>



</body>

</html>