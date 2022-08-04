package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.imp.PersonaDAOImp;
import dao.imp.SessionDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	private SessionDAOImp session;
	private PersonaDAOImp personaDAO;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.session = new SessionDAOImp();
		this.personaDAO = new PersonaDAOImp();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("inputEmail");
		String pass = request.getParameter("inputPassword");
		request.getSession().setAttribute("rol", "");


		try {
			if (Boolean.TRUE.equals(personaDAO.isAdmin(email))) {
				request.getSession().setAttribute("rol", "admin");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if (session.login(email, pass)) {
				if (personaDAO.validationUser(email, pass)) {
					request.getSession().setAttribute("email", email);
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/home.jsp");
					disp.forward(request, response);
				} else {
					request.getSession().setAttribute("message",
							"Ha ingresado un email y/o contraseña incorrectos, por favor vuelva a hacerlo.");
					request.getSession().setAttribute("error", "True");
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/auth.jsp");
					disp.forward(request, response);
				}
			}else {
				request.getSession().setAttribute("message",
						"Ha ingresado un email y/o contraseña incorrectos, por favor vuelva a hacerlo.");
				request.getSession().setAttribute("error", "True");
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/auth.jsp");
				disp.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}

}
