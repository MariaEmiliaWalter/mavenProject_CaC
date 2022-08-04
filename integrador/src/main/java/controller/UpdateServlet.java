package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.imp.MedicoDAOImp;
import dao.imp.PacienteDAOImp;
import dao.imp.PersonaDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medico;
import model.Paciente;
import utils.UtilsDAO;


@WebServlet("/modifierUser")
public class UpdateServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	private PacienteDAOImp pacienteDAO;
	private MedicoDAOImp medicoDAO;
	private PersonaDAOImp personaDAO;
	private UtilsDAO util;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.medicoDAO = new MedicoDAOImp();
		this.pacienteDAO = new PacienteDAOImp();
		this.personaDAO = new PersonaDAOImp();
		this.util = new UtilsDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("inputName").trim();
		String apellido = request.getParameter("inputLastname").trim();

		Integer dni = Integer.parseInt(request.getParameter("inputDni").trim());
		Integer telefono = Integer.parseInt(request.getParameter("inputTelefono").trim());
		String email = request.getParameter("inputEmail").trim();
		String password = request.getParameter("inputPassword").trim();
		String areaTrabajoValue = request.getParameter("areaTrabajoValue");
		
		String changeInLogout = request.getParameter("changeInLogout");
		String changeInPacientes = request.getParameter("changeInPacientes");

		Boolean valid = false;

		try {
			Integer idPersona = personaDAO.getByEmail(email).getId();
			Integer idMedico = medicoDAO.getByEmail(email).getId();
						
			if (idMedico.equals(idPersona)) {
				// new objeto medico
				Medico m = new Medico(util.capitalize(nombre), util.capitalize(apellido), email, password, telefono,
						dni,areaTrabajoValue);
				m.setId(idPersona);
				valid = medicoDAO.update(m);
			} else {
				// variables
				Integer edad = Integer.parseInt(request.getParameter("inputEdad"));
				String nacimiento = request.getParameter("Birthday");

				// date nacimiento
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
				LocalDate localDate = LocalDate.parse(nacimiento, formatter);
				Date dateNac = Date.valueOf(localDate);

				// new obj paciente
				Paciente p = new Paciente(util.capitalize(nombre), util.capitalize(apellido), email, password, telefono,
						dni, dateNac, edad);
				p.setId(idPersona);
				valid = pacienteDAO.update(p);
			}

			if (changeInLogout != null) {
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/profile");
				disp.forward(request, response);
			} else if (changeInPacientes != null) {
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/pacientes");
				disp.forward(request, response);
			}

		} catch (Exception e) {
			System.out.print(e);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/home");
			disp.forward(request, response);
		}

	}
}
