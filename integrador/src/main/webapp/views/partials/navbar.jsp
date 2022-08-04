
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.imp.MedicoDAOImp"%>

<nav class="navbar sticky-top navbar-expand-lg m-b5" id="navbar">
	<div class="container-fluid">
	
		<form action="home" method="POST">
		<button class="navbar-brand ms-5 btnNoStyle " type="submit" id="homeLogo"><img
			alt="logo" src="/integrador/assets/logo.png" height="50px"></button>
</form>		

		<button class="navbar-toggler" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
			aria-controls="offcanvasNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="offcanvas offcanvas-end" tabindex="-1"
			id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="offcanvasNavbarLabel"></h5>
				<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
					aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

					<li class="nav-item" aria-current="page">
						<form action="home" method="POST">
							<button class="nav-link btnNoStyle " type="submit" id="homeNavbar">Home</button>
						</form>
					</li>
					<%
					String rol = (String) request.getSession().getAttribute("rol");
					if (rol == "admin") {
					%>
					<li class="nav-item">
						<form action="pacientesServlet" method="POST">
							<button class="nav-link btnNoStyle" type="submit" id="pacientesNavbar">Pacientes</button>
						</form>
					</li>
					<%
					}
					%>
					<li class="nav-item">
						<form action="turnos" method="POST">
							<button class="nav-link btnNoStyle" type="submit" id="turnosNavbar">Turnos</button>
						</form>
					</li>

					<li class="nav-item">
						<form action="support" method="POST">
							<button class="nav-link btnNoStyle " type="submit" id="soporteNavbar">Soporte</button>
						</form>
					</li>

					<li class="nav-item">
						<form action="profile" method="POST">
							<button class="nav-link btnNoStyle" type="submit" id="profileNavbar">Mi
							perfil</button>
						</form>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
</nav>
