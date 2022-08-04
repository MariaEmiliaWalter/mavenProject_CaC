package controller;

import java.io.IOException;
import jakarta.servlet.Servlet;
import dao.imp.SessionDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static SessionDAOImp session = new SessionDAOImp();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		try {
			String email=(String) request.getSession().getAttribute("email");
			if (session.logout(email)) {
				request.getSession().removeAttribute("email");
				request.getSession().removeAttribute("rol");
			}
		}catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
}
