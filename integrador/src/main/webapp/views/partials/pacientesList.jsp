<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Paciente"%>
<%@page import="dao.imp.PacienteDAOImp"%>

<!-- variables  -->
<%
PacienteDAOImp pacienteDAO = new PacienteDAOImp();
String value = (String) request.getSession().getAttribute("value");
List<Paciente> listPacientes = new ArrayList<>();
Integer contador = 0;
if (value == null) {
	listPacientes = (ArrayList<Paciente>) request.getAttribute("listPacientes");
} else {
	listPacientes = pacienteDAO.searchP(value);
}
%>


<!------------  Contenido  ------------>
<div class="table-responsive">
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido</th>
				<th scope="col">Email</th>
				<th scope="col">Telefono</th>
				<th scope="col">Dni</th>
				<th scope="col">Alta Usuario</th>
				<th scope="col">Edad</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Paciente pac : listPacientes) {
			%>
			<tr>
				<th scope="row"><%=pac.getId()%></th>
				<td><%=pac.getNombre()%></td>
				<td><%=pac.getApellido()%></td>
				<td><%=pac.getEmail()%></td>
				<td><%=pac.getTelefono()%></td>
				<td><%=pac.getDni()%></td>
				<td><%=pac.getFechaAlta()%></td>
				<td><%=pac.getEdad()%></td>
				<td class="btn-group" role="group">
					<button type="submit" class="btn btnListPaciente btnDelete"
						data-bs-toggle="modal" data-bs-target="#deleteModal<%=contador%>"
						id="btnDelete<%=contador%>">Borrar</button> <input type="hidden"
					class="inputDeleteClass" value="<%=pac.getId()%>" />
					<button type="submit" class="btn btnListPaciente"
						data-bs-toggle="modal" data-bs-target="#changeModal<%=contador%>"
						id="btnChange<%=contador%>">Modificar</button>
				</td>
			</tr>
			<%
			contador = contador + 1;
			}
			%>
		</tbody>
	</table>
</div>

<%
for (Integer i = 0; i < contador; i++) {
%>
<!-- Modal delete -->
<div class="modal fade" id="deleteModal<%=i%>" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">&iquest;Estas seguro
					que desea borrar este paciente&quest;</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">No</button>
				<form method="POST" action="delete">
					<input type="hidden" class="inputHiddenDelete"
						name="inputHiddenDelete" value="<%=listPacientes.get(i).getId()%>">
					<button type="submit" class="btn btnModalOk">Si</button>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Modal cambiar -->
<div class="modal fade" id="changeModal<%=i%>" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalLabel"
	aria-hidden="true">
	<div
		class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modificar datos</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>

			<form class="col-10" action="signUp" method="POST">
				<div class="modal-body ">
					<%
					request.getSession().setAttribute("usuario", listPacientes.get(i));
					%>
					<jsp:include page="modifierForm.jsp" />

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Descartar</button>
					<input name="changeInLogout" type="hidden"
						value="changeInPacientes">
					<button type="submit" class="btn btnModalOk">Guardar
						cambios</button>
				</div>
			</form>
		</div>
	</div>
</div>

<%
}
%>