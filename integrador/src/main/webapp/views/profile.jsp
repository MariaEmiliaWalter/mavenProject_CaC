<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Persona"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Mi perfil</title>
</head>
<body>
	<!--Navbar -->
	<jsp:include page="partials/navbar.jsp"></jsp:include>

	<%
	String email = (String) request.getSession().getAttribute("email");
	System.out.println(email);
	Persona usuario = (Persona) request.getSession().getAttribute("usuario");
	String rol = (String) request.getSession().getAttribute("rol");
	%>
	<div class="container bgProfile ">
		<div class="row my-5 justify-content-center align-items-center">
			<div class="col-6 align-self-start divIdProfile">
				<svg class="iconProfile rounded-circle shadow-lg"
					data-jdenticon-value="user<%=usuario.getId()%>"></svg>
				<div class="badge rounded-pill badgeBg my-3">
					<h5 class="text-white">
						ID de usuario:
						<%=usuario.getId()%></h5>
				</div>
			</div>

			<div class="col-6 divDatosProfile">
				<h2 class="my-3">MI PERFIL</h2>
				<div class="my-2 d-flex">
					<h5 class="textUnderline me-2">Nombre:</h5>
					<h5><%=usuario.getNombre()%></h5>
				</div>

				<div class="my-2 d-flex">
					<h5 class="textUnderline me-2">Apellido:</h5>
					<h5><%=usuario.getApellido()%></h5>
				</div>
				<div class="my-2 d-flex">
					<h5 class="textUnderline me-2">Telefono:</h5>
					<h5><%=usuario.getTelefono()%></h5>
				</div>
				<div class="my-2 d-flex">
					<h5 class="textUnderline me-2">Dni:</h5>
					<h5><%=usuario.getDni()%></h5>
				</div>

				<div class="row btnGroupProfile ">
					<form class="col-6" action="logout" method="POST">
						<button type="submit" class="btn btnListPaciente">Salir</button>
					</form>
					<%
					if (rol == "admin") {
					%>
					<div class="col-6">
						<button type="submit" class="btn btnListPaciente"
							data-bs-toggle="modal" data-bs-target="#modalProfile">Modificar</button>
					</div>
						<%
						}
						%>
					</div>

				</div>
			</div>


			<!-- Modal cambiar -->
			<div class="modal fade" id="modalProfile" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalLabel"
				aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
					<div class="modal-content ">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modificar
								datos</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form class="col-10" action="modifierUser" method="POST"
							name="formModalProfile">
							<div class="modal-body">
								<jsp:include page="partials/modifierForm.jsp" />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Descartar</button>
								<input name="changeInLogout" type="hidden"
									value="changeInLogout">
								<button type="submit" class="btn btnModalOk">Guardar
									cambios</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Fin container -->
		</div>
</body>
</html>