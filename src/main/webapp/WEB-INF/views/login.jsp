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
		<title>Inicio Sesión</title>
		<link href="${contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet">
		<link href="${contextPath}/resources/css/login.css" rel="stylesheet">
	</head>
	<body>
	<!-- /container ini-->
	<div class="container">
		<div class="wrapper">
			<form  method="POST" action="${contextPath}/login" class="form-signin">
				<h4 class="form-signin-heading">Inicio Sesión</h4>
				<div class="form-group ${error != null ? 'has-error' : ''}">
					<div class="text-danger"><span>${message}</span></div>
					<input name="username" type="text"	class="form-control" placeholder="Nombre de Usuario" required autofocus/>
					<input name="password" type="password" class="form-control"	placeholder="Clave" required/> 					
					<div class="text-danger"><span>${error}</span></div>
					<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
					<div></div>
					<button class="btn btn-sm btn-primary btn-block" type="submit"><h6 class="text-center">Iniciar Sesión</h6></button>
					<h6 class="text-center">
						<a href="${contextPath}/registration">Crear Cuenta</a>
					</h6>
				</div>				
			</form>
		</div>
	</div>
	<!-- /container fin-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>