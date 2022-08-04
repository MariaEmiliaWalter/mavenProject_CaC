package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.imp.MedicoDAOImp;
import dao.imp.PacienteDAOImp;
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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	private PacienteDAOImp userP;
	private MedicoDAOImp userM;
	private UtilsDAO util ;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.userM = new MedicoDAOImp();
		this.userP = new PacienteDAOImp();
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
		Integer edad = Integer.parseInt(request.getParameter("inputEdad"));
		String nacimiento = request.getParameter("Birthday");
		Integer dni = Integer.parseInt(request.getParameter("inputDni").trim());
		Integer telefono = Integer.parseInt(request.getParameter("inputTelefono").trim());
		String email = request.getParameter("inputEmail").trim();
		String password = request.getParameter("inputPassword").trim();
		String firstSelectorUser = request.getParameter("firstSelectorUser");
		String areaTrabajoValue = request.getParameter("areaTrabajoValue");

		String formPinput = request.getParameter("formPinput");
		String formModalInput = request.getParameter("formModalInput");
		
		// alta de usuario
		Date dateAlta = Date.valueOf(LocalDate.now());

		// date nacimiento
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // corregir doble formateo
		LocalDate localDate = LocalDate.parse(nacimiento, formatter);
		Date dateNac = Date.valueOf(localDate);
		Boolean valid = false;

		try {
			if ("medico".equals(firstSelectorUser)) {
	
				// new objeto medico
				Medico m = new Medico(util.capitalize(nombre), util.capitalize(apellido), email, password, telefono, dni, dateAlta, areaTrabajoValue);
				valid = userM.insert(m);
			} else {
				// new obj paciente
				Paciente p = new Paciente(util.capitalize(nombre), util.capitalize(apellido), email, password, telefono, dni, dateAlta, dateNac, edad);
				valid = userP.insert(p);
			}

			if (formPinput != null || formModalInput!=null) {
				//con uno agrego paciente y con el otro <modifico.
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/pacientes");
				disp.forward(request, response);
			}else if (Boolean.TRUE.equals(valid)) {	
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/auth.jsp");
				disp.forward(request, response);
			} else {
				request.getSession().setAttribute("message",
						"Ha surgido un error. Por favor, vuelva a registrarse y disculpe las molestias.");
				request.getSession().setAttribute("error", "True");
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/signIn.jsp");
				disp.forward(request, response);
			}
		}catch(

	Exception e)
	{
		System.out.print(e);
	}
}}
