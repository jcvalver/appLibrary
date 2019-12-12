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
		<link href="${contextPath}/resources/css/register.css" rel="stylesheet">
	</head>
	<body>
	<!-- /container ini-->
	
	<div class="container">
		<div class="wrapper">
			<form  method="POST" action="${contextPath}/login" class="form-signin">
				<h4 class="form-signin-heading w-100 font-weight-bold">Inicio Sesión</h4>
				<div class="form-group ${error != null ? 'has-error' : ''}">
					<div class="text-danger"><span>${message}</span></div>
				
					<input name="username" type="text"	class="form-control" placeholder="Nombre de Usuario" required autofocus/>
					<input name="password" type="password" class="form-control"	placeholder="Clave" required/> 					
					<div class="text-danger"><span>${error}</span></div>
					<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />					
					<button class="btn btn-sm btn-primary btn-block" type="submit"><h6 class="text-center">Iniciar Sesión</h6></button>
					<h6 class="text-center">
						<a href="#" data-toggle="modal" data-target="#modalRegisterForm">Crear Cuenta</a>
					</h6>
				</div>		 		
			</form>
		</div>
	</div>
	<!-- /container fin-->
	
	<!-- modal register ini -->	
	<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
   			 <div class="modal-content">
      			<div class="modal-header text-center">
        			<h4 class="modal-title w-100 font-weight-bold ">Cuenta de Usuario</h4>
       				<button id="btnCloseRegisterUser" type="button" class="close" data-dismiss="modal" aria-label="Close">
         				 <span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body mx-3">
      				<form action="${contextPath}/user/register" id="registerUserForm" name="registerUserForm" method="POST" class="form-register" >      				
      					<div class="md-form mb-3">
      						<div class="form-control-register">
        						<i class="fas fa-user prefix grey-text"></i>        							
								<input type="text" name="userFullname" class="form-control-register-input" placeholder="Nombre Completo de Usuario" autofocus/>
							</div>
						</div>
						<div class="md-form mb-3 ">
							<div class="form-control-register">
								<i class="fas fa-envelope prefix grey-text"></i>	
								<input type="text" name="userEmail" class="form-control-register-input" placeholder="Email de Usuario"/>
							</div>
						</div>
						<div class="md-form mb-3 ">
							<div class="form-control-register">
								<i class="fas fa-user prefix grey-text"></i> 
								<input type="text" name="userName" class="form-control-register-input" placeholder="Nombre de Usuario"/>
							</div>
						</div>
						<div class="md-form mb-3 ">
							<div class="form-control-register">
								<i class="fas fa-lock prefix grey-text"></i>
								<input type="password" name="userPassword" class="form-control-register-input" placeholder="Clave"/>
							</div>
						</div>
						<div class="md-form mb-3 ">
							<div class="form-control-register">
								<i class="fas fa-lock prefix grey-text"></i>
								<input type="password" name="userPasswordConfirm" class="form-control-register-input" placeholder="Confirma tu Clave"/>	
							</div>
						</div>					
						<button id="btnRegisterUser" class="btn btn-sm btn-primary btn-block" >Registrarse</button>   							
        			</form>
      			</div>
      			
    		</div>
  		</div>
	</div>
    <!-- modal register fin -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/all.min.js"></script>
	
	<script type="text/javascript">
		$(function() { 

			 /*send data modal register ini*/			
  			 $('#btnRegisterUser').click(function(e) {    	

  				var confirmar = confirm("ï¿½Realmente deseas crear la cuenta de usuario? ");
  	            if (confirmar) {
  	            	 e.preventDefault();
  	            	 $.post({
  	       				  url : 'user/register',       				
  	        			  data : $('form[name=registerUserForm]').serialize(),        			 
  	      				  success : function(res) {
  	      							 if(res.status == "SUCCESS"){
  	      								 alert("se registro correctamente.");
  	      								 $("#registerUserForm")[0].reset();      						
  	      								 $("#modalRegisterForm").modal('hide');
  	      		            		 }else{
  	      		                 		errorInfo = "";
  	      		                		for(i =0 ; i < response.result.length ; i++)
  	      		                     		errorInfo +=  (i + 1) +". " + response.result[i].code;      		                 
  	      								alert('Error: ' + errorInfo);      		                
  	      		             		}          				
  	         					},
  	         	         error: function(e){
  	         	             alert('Error: ' + e);
  	         	         }
  	      			})
  	            } else {
  	                return false;
  	  			 	 	
  	            }
      			
   			}); 
  			/*send data modal register fin*/

 			$('#btnCloseRegisterUser').click(function(e) {   
 				$("#registerUserForm")[0].reset();     
 			});

  			
		});
	</script>
	</body>
</html>