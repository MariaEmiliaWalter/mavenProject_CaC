package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.imp.PacienteDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paciente;

@WebServlet("/pacientes")
public class ListPacientesServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private PacienteDAOImp pacienteDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.pacienteDAO = new PacienteDAOImp();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Paciente> pacientes = null;
		try {
			pacientes = this.pacienteDAO.getAll();
			request.setAttribute("listPacientes", pacientes);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/pacientes.jsp");
			disp.forward(request, response);
			
		} catch (SQLException e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}

}
	
	



