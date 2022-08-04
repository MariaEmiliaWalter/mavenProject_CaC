<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="views/partials/head.jsp"></jsp:include>
<title>Consultorio</title>
</head>

<body>
<div class=" container-fluid my-5">
		<H1 class="text-center textIndex">La aplicación ideal para
			profesionales de la salud</H1>
			
<!-- login or register -->
		<div class="container">
			<form class="row justify-content-center align-items-center bgIndex"
				action="inicio" method="POST">
				<div class="col-6 colIndex">
					<img src="/integrador/assets/index.png" class="" alt="logo" height="500px">
				</div>
				<div class="col-6">
					<button type="submit" class="btn btnCustome" value="login"
						name="submit">Ingresar</button>
					<button type="submit" class="btn btnCustome" value="signIn"
						name="submit">¡Soy nuevo!</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>