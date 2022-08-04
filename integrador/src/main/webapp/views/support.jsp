<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<title>Soporte</title>
</head>
<body>
	<!--Navbar -->
	<jsp:include page="partials/navbar.jsp"></jsp:include>
	
		<!--Contenido -->
<div class="container my-5 ">
		<div
			class="row  row-cols-1 row-cols-md-2 row-cols-lg-2 g-4  justify-content-around align-items-center containerHome">
			<div class="col">
				<img src="/integrador/assets/support.png" class="card-img-top" alt="..." />
			</div>
			
			<div class="col row-cols-1">
				<h1 class="text-break mb-5 fontSupport">&iexcl;Gracias por elegirme!	</h1>
				<a type="button" class="nav-link btnNoStyle mb-2 text-center" href="https://github.com/MariaEmiliaWalter" target="_blank" rel="noreferrer noopener"><i class="fa fa-brands fa-github me-3"></i>GITHUB</a>
				<a type="button" class="nav-link btnNoStyle mb-2 text-center" href="https://www.linkedin.com/in/maria-emilia-walter/" target="_blank" rel="noreferrer noopener"><i class="fa fa-brands fa-linkedin me-3"></i>LINKEDIN</a>
				<a type="button" class="nav-link btnNoStyle mb-2 text-center" href="https://www.behance.net/Mariaemiliawalter" target="_blank" rel="noreferrer noopener"><i class="fa fa-brands fa-behance me-3"></i>BEHANCE</a>
				
		</div>


	</div>
</body>
</html>