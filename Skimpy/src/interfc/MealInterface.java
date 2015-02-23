package interfc;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MealInterface extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 102831973239L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*String userAgent =  req.getHeader("user-agent");
		String clientBrowser =  "Not known!";	
		if( userAgent != null)
			clientBrowser = userAgent;
		req.setAttribute("client.browser",clientBrowser );*/
		req.getRequestDispatcher("/MealPlan.jsp").forward(req,resp);
	}
}