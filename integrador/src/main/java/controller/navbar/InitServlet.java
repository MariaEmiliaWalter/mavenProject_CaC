package controller.navbar;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class InitServlet extends HttpServlet  implements Servlet{
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String valorSubmit = request.getParameter("submit");
		if( valorSubmit.equals("login"))  {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/auth.jsp");
			disp.forward(request, response);
		}else{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/signIn.jsp");
			disp.forward(request, response);

		}
	}

}
