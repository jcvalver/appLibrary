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
<title>Country</title>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/layout/header.css" rel="stylesheet">	
	<link href="${contextPath}/resources/css/layout/navBar.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/layout/footer.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/administrative/country.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body>
	<!-- /navBar ini-->
  	<jsp:include page="../layout/navBar.jsp"/>
	<!-- /navBar fin-->
	<!-- /container ini-->

	<div class="container-fluid container-fluid-dashboard">
		<jsp:include page="../layout/header.jsp"/>	
		<div class="wrapper">
			<div class="button-register">
				<a id="btnAdd" data-toggle="modal" data-target="#modalRegisterForm" href="" class="btn btn-primary custom-width">Add</a>
			</div>
			<div class="table-initialized">-------------------------</div>
			<table id="table-country" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Código</th>
						<th>País</th>	
						<th>Estado</th>
						<th></th>
						<th></th>				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${countrys}" var="country">
                    	<tr>
                        	<td>${country.countryId}</td>
                        	<td>${country.countryDescription}</td>   
                        	<c:set var="countryState" value="${country.countryState}"/>
                        	<c:choose>
                        		 <c:when test="${countryState=='false'}">
                        			 <td><div class="circulo_inactive"></div></td>
                        		 </c:when> 
                        		 <c:otherwise> <td><div class="circulo_active"></div></td></c:otherwise>
                        	</c:choose>                        	                     	
                       		<td><a id="btnEditCountry"    href="javascript:update('${country.countryId}');" class="btn btn-success custom-width"><i class="far fa-edit"></i></a></td>
                       		<td><a id="btnDeleteCountry"  href="javascript:deleted('${country.countryId}');" class="btn btn-danger custom-width"> <i class="far fa-trash-alt"></i></a></td>
                    	</tr>
                </c:forEach>					
				</tbody>				
			</table>
			<div class="table-finished">-------------------------</div>		
		</div>
	</div>
	<!-- /container fin-->
	<!-- /footer ini-->
	<jsp:include page="../layout/footer.jsp"/>
	<!-- /footer fin-->
	
	<!-- modal register ini -->	
	<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
   			 <div class="modal-content" >
      			<div class="modal-header text-center">
        			<h4 class="modal-title w-100 font-weight-bold ">País</h4>
       				<button id="btnCloseRegisterCountry" type="button" class="close" data-dismiss="modal" aria-label="Close">
         				 <span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body mx-3">
      				<form action="${contextPath}/country/register" id="registerCountryForm" name="registerCountryForm" method="POST" class="form-register" >      				
      					<div class="md-form mb-3">
      						<div class="form-control-register">   
      							<input type="hidden" id="countryId" name="countryId"/>     						     							
								<input type="text" id="countryDescription" name="countryDescription" class="form-control-register-input" placeholder="Descripción" autofocus/>
							</div>
						</div>							
						<input type="button" id="btnRegisterCountry" class="btn btn-sm btn-primary btn-block" value="Registrar"/>						   							
        			</form>
      			</div>
      			
    		</div>
  		</div>
	</div>
    <!-- modal register fin -->
	
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/all.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>

	<script type="text/javascript">
		var idOption=0;
		
		$(document).ready(function() {
			$('#table-country').DataTable({					  
				 "language": {
					 "emptyTable":     "Sin Data Disponible",
				      "info": "_START_ a _END_ de _TOTAL_ ",
				      "lengthMenu":     "_MENU_ registros",
				      "search":         "Buscar:",
				      "paginate": {
					        "first":      "primero",
					        "last":       "último",
					        "next":       "Siguiente",
					        "previous":   "Anterior"
					   		}
				    }					
				});

			//alert("probando si se llama");
		});

		$(function() {
			/*send data modal edit country ini*/
			$('#btnRegisterCountry').click(function(e) {			
						e.preventDefault();		
						saveOrUpdate();				
			});
			/*send data modal edit country fin*/			

			$('#btnCloseRegisterCountry').click(function(e) {
				$("#registerCountryForm")[0].reset();
			});

			$('#btnAdd').click(function(e) {
				idOption=1;
				$("#registerCountryForm")[0].reset();
				 $("#countryId").val('0');
				$("#btnRegisterCountry").val('Registrar');  
			});
			
		});

		 function saveOrUpdate(){
			
	          if(idOption==1){//guardar
	        	  var confirmar = confirm("¿Realmente deseas registrar el País? ");
					if (confirmar) {
						var jsonCompleto = JSON.stringify($('form[name=registerCountryForm]').serialize()); 						
						jsonCompleto = jsonCompleto.replace(/([{,])(\s*)([A-Za-z1-9_\-]+?)\s*:/g, '$1"$3":');
						var parseJson = JSON.parse(jsonCompleto);
						$.post({
							url : 'country/register',
							data : parseJson,
							success : function(res) {
										if (res.status == "SUCCESS") {
											alert("Se registro correctamente.");
											$("#registerCountryForm")[0].reset();
											$("#modalRegisterForm").modal('hide');											
										} else {
											alert('Error success: '+ res);
										}
										location.reload();
										
									},
							error : function(error) {
										alert('Error: ' + error);
									}
							
						})							
						
					} else {
						return false;
					}
		      }else{
			      //editar
					 var confirmar = confirm("¿Realmente deseas actualizar el País? ");
					if (confirmar) {
						var jsonCompleto = JSON.stringify($('form[name=registerCountryForm]').serialize()); 						
						jsonCompleto = jsonCompleto.replace(/([{,])(\s*)([A-Za-z1-9_\-]+?)\s*:/g, '$1"$3":');
						var parseJson = JSON.parse(jsonCompleto);						
						var idCountry=$("#countryId").val();
						$.ajax({
							url : 'country/edit/'+idCountry,
							method: 'POST',
							data:  parseJson,
							success : function(res) {
										if (res.status == "SUCCESS") {
											alert("Se actualizó correctamente.");
											$("#registerCountryForm")[0].reset();
											$("#modalRegisterForm").modal('hide');											
										} else {
											alert('Error Success: '+ errorInfo);
										}

										location.reload();
										
									},
							error : function(error) {
										alert('Error: ' + error);
									}
							
						})
					} else {
						return false;
					}

			  }
	        }

		 function update(id){
			 	idOption=2;
	            $.ajax({
	                url: 'country/edit/'+id,
	                method: 'GET',
	                contentType: 'application/json',
	                success: function (data, textStatus, xhr) {

		              //  alert("status:"+data.countryDescription);
	                    $("#countryId").val(data.countryId);
	                    $("#countryDescription").val(data.countryDescription);
	                 //   $('#txtId').val(data.id);
	                 //   getAllBooks();	     
	                   $("#btnRegisterCountry").val('Actualizar');                              
	                    $("#modalRegisterForm").modal("show");
	                  
	                	
	                },
	                error: function (error) {
	                    alert("error:"+error);
	                }
	            })
	        }

		 function deleted(id){
			 var confirmar = confirm("¿Realmente deseas eliminar el País? ");
			 if (confirmar) {
				 $.ajax({
		                url: 'country/delete/'+id,
		                method: 'GET',
		                contentType: 'application/json',
		                success: function (data, textStatus, xhr) {
		                	if (data.status == "SUCCESS") {
								alert("Se eliminó correctamente.");
								$("#registerCountryForm")[0].reset();
								$("#modalRegisterForm").modal('hide');											
							} else {
								alert('Error Success: '+ errorInfo);
							}

							location.reload();           	
		                },
		                error: function (error) {
		                    alert("error:"+error);
		                }
		            })
			 }
	           
	        }

		
	</script>
</body>
</html>