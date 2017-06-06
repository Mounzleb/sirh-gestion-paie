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
				
			</div>
			<!--/.nav-collapse -->
	
	</nav>
	<br>
	<br>
	<br>
	<br>
	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Ajouter un employé</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Matricule</label>
				<div class="col-md-4">
					<input id="matricule" name="matricule" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Select Basic Entreprise -->

			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Entreprise</label>
				<div class="col-md-4">
					<select id="Entreprise" name="entreprise" class="form-control">
						<c:forEach var="entreprise" items="${listeEntreprise}">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
					<!-- </select> -->
				</div>
			</div>

			<!-- Select Basic Profil de Remuneration -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Profil</label>
				<div class="col-md-4">
					<select id="Profil" name="profil" class="listeProfil">
						<c:forEach var="profil" items="${listeProfil}">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic Grade -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Grade</label>
				<div class="col-md-4">
					<select id="Grade" name="grade" class="form-control">
						<c:forEach var="grade" items="${listeGrade}">
							<option value="${grade.id}">${grade.code}</option>
						</c:forEach>
					</select>
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