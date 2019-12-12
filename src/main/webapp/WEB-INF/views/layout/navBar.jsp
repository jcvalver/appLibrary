   <!-- /navbar ini-->
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark fixed-top">
		<a class="navbar-brand" href="#">TecaBook</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link active" href="#"><i class="fa fa-fw fa-home"></i> Inicio</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Administración</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Usuarios</a> 
						<a class="dropdown-item" href="#">Roles</a> <a class="dropdown-item" href="#">Permisos</a> 
						<a class="dropdown-item" href="country">Paises</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Libros</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Autores</a> 
						<a class="dropdown-item" href="#">Categorias</a> 
						<a class="dropdown-item" href="#">Libros</a>
					</div></li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Reservación</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Proceso de Reserva</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Control de Lectura</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Proceso de Lectura</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Reportes</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Libros Reservados x Usuario</a>
						<a class="dropdown-item" href="#">Libros Leidos x Usuario</a>
						<a class="dropdown-item" href="#">Usuarios Nuevos Registrados</a>
						<a class="dropdown-item" href="#">Libros Nuevos Registrados</a>
					</div>
				</li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown">
				 	<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">${pageContext.request.userPrincipal.name} 
				 		<i class="fa fa-user fa-fw"></i>
				 	</a>
					<div class="dropdown-menu dropdown-menu-perfil">
						<a class="dropdown-item" href="#"><i class="fa fa-user fa-fw"></i>Perfil</a>
						<a class="dropdown-item" href="#"><i class="fa fa-cogs  fa-fw"></i>Config</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="fa fa-window-close fa-fw"></i> Salir</a>
					</div></li>
			</ul>
		</div>
	</nav>
	<!-- /navbar fin-->		