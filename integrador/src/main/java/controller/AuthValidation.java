package controller;

import java.io.IOException;


import dao.imp.PersonaDAOImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/authValidation")
public class AuthValidation extends HttpServlet  implements Servlet{
	
	private static final long serialVersionUID = 1L;
	
		private PersonaDAOImp persona;
		
		@Override
		public void init (ServletConfig config) throws ServletException{
			super.init(config);
			this.persona= new PersonaDAOImp();
		}
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = (String) request.getSession().getAttribute("inputEmail");
		String inputPassword = (String) request.getSession().getAttribute("inputPassword");
		
		String rol1 = (String) request.getSession().getAttribute("rol1");
				try {
				if ( persona.validationUser(inputEmail, inputPassword) ) {
					request.getSession().setAttribute("rol", rol1 );
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/home.jsp");
		            disp.forward(request, response);
		            
				} else {
					request.getSession().setAttribute("message",
							"Ha ingresado un email y/o contraseña incorrectos, por favor vuelva a hacerlo.");
					request.getSession().setAttribute("error", "True");
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/views/auth.jsp");
		            disp.forward(request, response);
				}
			} catch (Exception e) {
				System.out.print(e);
				e.printStackTrace();
			}
		}
		
	}




