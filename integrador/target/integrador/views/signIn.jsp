<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Registro</title>
</head>
<body class="bg-body ">

	<div class="container my-5">
		<div class="row justify-content-center">
			<form class="col-6" action="signUp"
				method="POST">
				<div class="mb-3">
					<h4>
						<a href="."><i class="fa fa-arrow-left goBack"
							aria-hidden="true"></i></a> Datos personales
					</h4>
				</div>
				<jsp:include page="partials/formUser.jsp"></jsp:include>

				<button type="submit" class="btn btnCustome2 col-12">Registrarse</button>
			</form>

			<%
			Boolean error = Boolean.parseBoolean((String) session.getAttribute("error"));
			String message = (String) session.getAttribute("message");

			if (error) {
				out.println("<p class='text-danger text-center'>" + message + "</p>");
			}
			%>

		</div>
	</div>
</body>

</html>