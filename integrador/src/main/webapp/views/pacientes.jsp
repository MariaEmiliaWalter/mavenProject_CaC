<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Pacientes</title>

</head>
<body>
	<!--Navbar -->
	<jsp:include page="partials/navbar.jsp"></jsp:include>

	<!-- Contenido : cards  -->
	<div class="container marginTop ">
		<div class="row g-4 mb-5" style="text-align: -webkit-center;">
			<div class="col-6">
				<div class="card text-center cardSectionP ">
					<button class="btn card-body btnCustomeCard" role="div"
						type="submit" id="btnPacientesAdd"
						onclick="onHandleClick('formP')">Nuevo paciente</button>
				</div>

			</div>

			<div class="col-6">
				<div class="card text-center cardSectionP ">
					<button class="btn card-body btnCustomeCard" role="div"
						type="submit" onclick="onHandleClick('formListP')">Ver
						lista de pacientes</button>
				</div>
			</div>
		</div>

<!-------------- Separador ---------------->

<hr class="border border-2 opacity-50 borderHr my-3 ">

		<!-------------- Open ---------------->

		<div class="container my-5">
			<div class="row justify-content-center">

				<!-- Form Add paciente -->
				<form class="col-10 formContent" action="signUp" method="POST"
					name="formP" id="formP">
					<input name="formModalInput" type="hidden" value="formPinput">
					<div class="mb-3">
						<h4>Datos personales</h4>
					</div>
					<jsp:include page="partials/formUser.jsp" />
					<button type="submit" class="btn btnCustome2 col-12">Guardar
						paciente</button>
				</form>


				<!-- Form list pacientes -->
				<div class="col-10 formContent" id="formListP">
					<div class="mb-3">
						<%
						Boolean error = Boolean.parseBoolean((String) session.getAttribute("error"));
						String message = (String) session.getAttribute("msgDeletePaciente");

						if (error) {
							out.println("<p class='text-danger text-center'>" + message + "</p>");
						}
						%>
						<jsp:include page="partials/pacientesList.jsp" />
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>