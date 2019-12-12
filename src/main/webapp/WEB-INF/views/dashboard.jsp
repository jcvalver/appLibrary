<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="Administrador de Libros">
	<meta name="author" content="teczuka devp">
	<title>Dashboard AppLibrary</title>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/layout/header.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/layout/navBar.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/layout/footer.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>
  	<!-- /navBar ini-->
  	<jsp:include page="layout/navBar.jsp"/>
	<!-- /navBar fin-->
	<!-- /container ini-->
	<div class="container-fluid lead container-fluid-dashboard">
		<jsp:include page="layout/header.jsp"/>		
		<section>
			<article >					
				<p> Bienvenido a la web administrativa de libros físicos y digitales,
					reservación de libros, control de lectura y reportería. 
					<br> En esta web vas a poder realizar las siguientes operaciones:
				</p>
			</article>
		</section>
		<aside>
				<ul class="content-dashboard">
				<li>
					<input type="checkbox" name="list" id="nivel1-1"> 
					<label for="nivel1-1">Administrativas</label>
					<ul class="interior">
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Usuarios...</a></li>
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Roles...</a></li>
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Permisos...</a></li>
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Paises...</a></li>
					</ul>
				</li>
				<li>
					<input type="checkbox" name="list" id="nivel1-2"> 
					<label for="nivel1-2">Libros</label>
					<ul class="interior">
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Autores...</a></li>
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Categorias...</a></li>
						<li><a href="#r">Buscar, Agregar, Modificar y Eliminar Libros...</a></li>
					</ul>
				</li>
				<li>
					<input type="checkbox" name="list" id="nivel1-3"> 
					<label for="nivel1-3">Reservación</label>
					<ul class="interior">
						<li><a href="#r">Buscar, separar y asignarse un libro para lectura...</a></li>
					</ul>
				</li>
				<li>
					<input type="checkbox" name="list" id="nivel1-4"> 
					<label for="nivel1-4">Control de Lectura</label>
					<ul class="interior">
						<li><a href="#r">Seguimiento de los libros reservados...</a></li>
					</ul>
				</li>
				<li>
					<input type="checkbox" name="list" id="nivel1-5"> 
					<label for="nivel1-5">Reportes</label>
					<ul class="interior">
						<li><a href="#r">Reporte de Libros Reservados x Usuario...</a></li>
						<li><a href="#r">Reporte de Libros Leidos x Usuario...</a></li>
						<li><a href="#r">Reporte de Usuarios Nuevos Registrados...</a></li>
						<li><a href="#r">Reporte de Libros Nuevos Registrados...</a></li>
					</ul>
				</li>
				</ul>
			</aside>	
	</div>
	<!-- /container fin-->	
	<!-- /footer ini-->
	<jsp:include page="layout/footer.jsp"/>
	<!-- /footer fin-->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/all.min.js"></script>
</body>
</html>