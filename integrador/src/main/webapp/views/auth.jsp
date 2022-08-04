<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Inicio de sesion</title>
</head>
<body>

	<div class="container-fluid  my-5">
		<div class="row" id="rowAuth">
			<div class="card my-5" id="cardAuth">
				<img src="/integrador/assets/auth.svg" class="card-img-top my-4"
					alt="ingresoUsuario" id="imgAuth">

				<form class="mb-5 col-8 " action="login"
					method="POST">

					<div class="mb-3">
						<label for="inputEmail" class="form-label">Email</label> <input
							type="email" class="form-control" id="inputEmail"
							name="inputEmail" placeholder="Ingrese su email..." required
							autofocus>
					</div>

					<div class="mb-3">
						<label for="inputPassword" class="form-label">Contraseña</label> <input
							type="password" class="form-control" id="inputPassword"
							name="inputPassword" placeholder="Ingrese su clave..." required>
					</div>

					<div class="col-12">
						<div class="row" id="rowButtons">
							<a role="button" class="col-2 btn btn-outline-primary" href=".">
								<i class="fa fa-arrow-left "></i>
							</a>
							<button type="submit" class="col-10 btn btn-outline-primary " onclick="localStorage()">Ingresar</button>
						</div>
					</div>
					<%
					Boolean error = Boolean.parseBoolean((String) session.getAttribute("error"));
					String message = (String) session.getAttribute("message");

					if (error) {
						out.println("<p class='text-danger text-center'>" + message + "</p>");
					}
					%>
				</form>

			</div>
		</div>
	</div>

</body>
</html>