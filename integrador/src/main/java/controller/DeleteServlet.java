package controller;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet implements Servlet {
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
		Integer idDelete = Integer.parseInt(request.getParameter("inputHiddenDelete"));		
		try {
			request.getSession().setAttribute("error", "False");
			Paciente paciente = pacienteDAO.getById(idDelete);
			pacienteDAO.delete(paciente);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("msgDeletePaciente",
					"Ha surgido un error al intentar eliminar un paciente.");
			request.getSession().setAttribute("error", "True");
		}
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/pacientes");
		disp.forward(request, response);
	}

}
