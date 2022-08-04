<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Home</title>
</head>
<body class="bg-body">

	<!--Navbar -->
	<jsp:include page="partials/navbar.jsp"></jsp:include>

	<div class="container my-5 ">

		<div
			class="row  row-cols-1 row-cols-md-2 row-cols-lg-2 g-4  justify-content-around align-items-center containerHome">
			<div class="col homeText ">
				<h1 class="text-break">
					Cuidamos <br> tu tiempo y tu salud
				</h1>
				<h4 class=" mb-5">&iexcl;Obtene una consulta super facil!</h4>
				<button type="button" class="btn   btnCustome mb-5">TURNO
					ONLINE</button>
			</div>
			<div class="col">
				<img src="/integrador/assets/home-03.png" class="card-img-top" alt="..." />
			</div>
		</div>


	</div>

</body>
</html>