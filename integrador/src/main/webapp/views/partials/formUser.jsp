<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- Datos personales -->
<div class="mb-3">
	<label for="inputName" class="form-label">Nombre</label> <input
		type="text" class="form-control" id="inputName" name="inputName"
		placeholder="Ingrese su nombre..." required autofocus>
</div>
<div class="mb-3">
	<label for="inputLastname" class="form-label">Apellido</label> <input
		type="text" class="form-control" id="inputLastname"
		name="inputLastname" placeholder="Ingrese su apellido..." required>
</div>



<div class="mb-3">
	<label for="date" class="col-form-label">Fecha de nacimiento:</label>
	<div class="input-group date " id="datepicker">
		<input type="text" class="form-control " id="date" name="Birthday"
			placeholder="Ingrese su fecha de nacimiento..."  onchange="onHandleAge()" required>
		<span class="input-group-append "> <span
			class="input-group-text bg-light d-block"> <i
				class="fa fa-calendar" aria-hidden="true"></i></span>
		</span>
	</div>
</div>

<div class="mb-3">
	<label for="inputEdad" class="form-label ">Edad</label> <input
		type="text" class="form-control" id="inputEdad" name="inputEdad"  value="" placeholder="Su edad..."
		 required>
</div>

<div class="mb-3">
	<label for="inputDni" class="form-label">Dni</label> <input type="text"
		class="form-control" id="inputDni" name="inputDni"
		placeholder="Ingrese su dni, sin puntos ni comas..." required>
</div>

<div class="mb-3">
	<label for="inputTelefono" class="form-label">Telefono de
		contacto</label> <input type="text" class="form-control" id="inputTelefono"
		name="inputTelefono" placeholder="Ingrese su telefono..." required>
</div>


<div class="mb-3">
	<label for="firstSelectorUser" class="form-label">¿Usted es
		médico o paciente?</label> <select class="form-select optionSelected"
		aria-label="tipo de usuario" id="firstSelectorUser" name="firstSelectorUser" onchange="onChangeSelected()">
		<option selected disabled value="">Seleccione una opción...</option>
		<option value="paciente">Paciente</option>
		<option value="medico">Medico</option>
	</select>
</div>

<div class="mb-3" id="selectAreaTrabajo">
	<label for="selectAreaTrabajo" class="form-label  ">Area de
		trabajo</label> <select  class="form-select optionSelected"
		aria-label=""  id="areaTrabajoValue"  name="areaTrabajoValue">
		<option selected disabled value="">Seleccione una opción...</option>
		<option value="general">General</option>
		<option value="ginecologia">Ginecologia</option>
		<option value="odontologia">Odontologia</option>
		<option value="traumatologia">Traumatologia</option>
	</select>
</div>


<!-- Alta usuario -->
<div class="mb-3">
	<h4>Datos para ingresar a la plataforma</h4>
</div>
<div class="mb-3">
	<label for="inputEmail" class="form-label">Email</label> <input
		type="email" class="form-control" id="inputEmail" name="inputEmail"
		placeholder="Ingrese un email..." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
</div>
<div class="mb-3">
	<label for="inputPassword" class="form-label">Contraseña</label> <input
		type="password" class="form-control" id="inputPassword"
		name="inputPassword" placeholder="Ingrese una clave..." 
		pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{,10}" required>
		<p class="ms-2 fw-bold">Importante: Su clave debe contener hasta 10 caracteres, una mayúscula y un número.</p>
</div>


