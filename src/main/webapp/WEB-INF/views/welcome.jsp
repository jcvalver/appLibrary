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

		<title>Bienvenido</title>

		<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	    <!-- /container ini-->
		<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				 <button class="btn btn-lg btn-primary btn-block" type="submit">Logout</button> 
			</form>
			<h2> 
				Welcome ${pageContext.request.userPrincipal.name} | 
				
				<!-- <a onclick="document.forms['logoutForm'].submit()">Logout</a>  -->
			</h2>
		</c:if>
	  	</div>
		<!-- /container fin-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>