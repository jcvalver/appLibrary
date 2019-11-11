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

		<title>Crear Cuenta</title>
		<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/login.css" rel="stylesheet">
	</head>
	<body>
		<!-- /container ini-->
		<div class="container">
			<div class="wrapper">
			<form:form method="POST" modelAttribute="libraryUserForm" class="form-signin">
				<h2 class="form-signin-heading">Crear Cuenta</h2>
				<spring:bind path="userFullname">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="userFullname" class="form-control" placeholder="Nombre Completo de Usuario" autofocus="true"></form:input>
						<form:errors path="userFullname"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="userEmail">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="userEmail" class="form-control" placeholder="Email de Usuario" ></form:input>
						<form:errors path="userEmail"></form:errors>
					</div>
				</spring:bind>				
				<spring:bind path="userName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="userName" class="form-control" placeholder="Nombre de Usuario" autofocus="true"></form:input>
						<form:errors path="userName"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="userPassword">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="userPassword" class="form-control" placeholder="Clave"></form:input>
						<form:errors path="userPassword"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="userPasswordConfirm">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="userPasswordConfirm" class="form-control" placeholder="Confirma tu Clave"></form:input>
						<form:errors path="userPasswordConfirm"></form:errors>
					</div>
				</spring:bind>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			</form:form>
			</div>
		</div>
		<!-- /container fin-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>