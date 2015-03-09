package interfc;

import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MealInterface extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").forward(request,response);
		
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("login.jsp"); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals(username) && password.equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcome.jsp");
			}else{
				request.setAttribute("message", "Account is invalid");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}
	
}
