package controller.navbar;

import java.io.IOException;
import java.sql.SQLException;

import dao.imp.PersonaDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAOImp persona = new PersonaDAOImp();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		try {
				request.getSession().setAttribute("usuario", persona.getByEmail(email));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/profile.jsp");
		disp.forward(request, response);
	}

}