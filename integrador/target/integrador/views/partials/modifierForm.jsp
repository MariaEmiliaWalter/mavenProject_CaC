
<%@page import="dao.imp.MedicoDAOImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Persona"%>
<%@page import="model.Paciente" %>
<%@page import="model.Medico" %>
<%@page import="dao.imp.PacienteDAOImp"%>
<%@page import="dao.imp.MedicoDAOImp"%>

<% String rol = (String) request.getSession().getAttribute("rol"); 
Persona usuario = (Persona) request.getSession().getAttribute("usuario");
PacienteDAOImp dao = new PacienteDAOImp();
MedicoDAOImp daoM = new MedicoDAOImp();

Integer IdUser = usuario.getId();
Paciente paciente = dao.getById(IdUser);
Medico medico = daoM.getById(IdUser);

%> 

 <!-- Data -->
<div class="mb-3">
	<label for="inputName" class="form-label">Nombre</label> <input
		type="text" class="form-control" id="inputName" name="inputName"
		value="<%=usuario.getNombre() %>" placeholder="Ingrese su nombre..."  required autofocus>
</div>
<div class="mb-3">
	<label for="inputLastname" class="form-label">Apellido</label> <input
		type="text" class="form-control" id="inputLastname"
		name="inputLastname" placeholder="Ingrese su apellido..." value="<%=usuario.getApellido()%>" required>
</div>

<div class="mb-3">
	<label for="inputDni" class="form-label">Dni</label> <input type="text"
		class="form-control" id="inputDni" name="inputDni"
		placeholder="Ingrese su dni, sin puntos ni comas..." value="<%= usuario.getDni()%>" required>
</div>

<div class="mb-3">
	<label for="inputTelefono" class="form-label">Telefono de
		contacto</label> <input type="text" class="form-control" id="inputTelefono"
		name="inputTelefono" placeholder="Ingrese su telefono..." value="<%= usuario.getTelefono()%>"  required>
</div>

<% if("admin".equals(rol) && paciente!=null ){  %>
<!-- Other data for pacient-->
<div class="mb-3">
	<label for="date" class="col-form-label">Fecha de nacimiento:</label>
	<div class="input-group date " id="datepicker">
		<input type="text" class="form-control " id="date" name="Birthday"
			placeholder="Ingrese su fecha de nacimiento..."  onchange="onHandleAge()" value="<%= paciente.getNacimiento()%>"  required>
		<span class="input-group-append "> <span
			class="input-group-text bg-light d-block"> <i
				class="fa fa-calendar" aria-hidden="true"></i></span>
		</span>
	</div>
</div>

<div class="mb-3">
	<label for="inputEdad" class="form-label ">Edad</label> <input
		type="text" class="form-control" id="inputEdad" name="inputEdad"  value="<%=paciente.getEdad() %>" placeholder="Su edad..."
		 required>
</div>
<%}%>
<!-- Data user login -->
<% if( medico!=null){ %>

<div class="mb-3" >
	<label for="selectAreaTrabajo" class="form-label  ">Area de
		trabajo</label> <select  class="form-select optionSelected"
		aria-label=""  id="areaTrabajoValue"  name="areaTrabajoValue">
		<option selected disabled value="<%=medico.getAreaDeTrabajo() %>">Seleccione una opción...</option>
		<option value="general">General</option>
		<option value="ginecologia">Ginecologia</option>
		<option value="odontologia">Odontologia</option>
		<option value="traumatologia">Traumatologia</option>
	</select>
</div>

<div class="mb-3">
	<h4>Datos para ingresar a la plataforma:</h4>
</div>
<div class="mb-3">
	<label for="inputEmail" class="form-label">Email</label> <input
		type="email" class="form-control" id="inputEmail" name="inputEmail"
		placeholder="Ingrese un email..." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="<%=usuario.getEmail() %>" required>
</div>
<div class="mb-3">
	<label for="inputPassword" class="form-label">Contraseña</label> <input
		type="password" class="form-control" id="inputPassword"
		name="inputPassword" placeholder="Ingrese una clave..." 
		pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{,10}" required>
		<p class="ms-2 fw-bold">Importante: Su clave debe contener hasta 10 caracteres, una mayúscula y un número.</p>
</div>

<%}else{%>
<div class="mb-3">
	<h4>Datos para ingresar a la plataforma</h4>
</div>
<div class="mb-3">
	<label for="inputEmail" class="form-label">Email</label> <input
		type="email" class="form-control" id="inputEmail" name="inputEmail"
		placeholder="Ingrese un email..." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="<%=usuario.getEmail() %>" required>
</div>
<div class="mb-3">
	<label for="inputPassword" class="form-label">Contraseña</label> <input
		type="password" class="form-control" id="inputPassword"
		name="inputPassword" placeholder="Ingrese una clave..." 
		pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{,10}" required>
		<p class="ms-2 fw-bold">Importante: Su clave debe contener hasta 10 caracteres, una mayúscula y un número.</p>
</div>
<%}%>