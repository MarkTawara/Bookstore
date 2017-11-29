package boundary;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;
//import logic_layer.Logic;

@WebServlet("/LoginServlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String globalEmail = "";

	/**
	 * Constructor
	 */
	public Login_Servlet() {
		super();
	}

	
	/**
	 * Verify the login credentials. Send user to index.jsp on success, and ___ on failure
	 */
	public void verify_login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		//Get variables from user
		String email = request.getParameter("reg_email");
		String password = request.getParameter("reg_password");
		
		//Check if there is already a session running. If there is, terminate it
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		//The next forwarded page
		String nextJSP = "/index.jsp";
		
		//check if the user exists and allow the user to log in
		bookstore_query query = new bookstore_query();
		boolean checkLogin = query.validate_user(request, response, email, password);
		
		if (checkLogin) {
			//Track the session based on the email provided
			session = request.getSession();
			session.setAttribute("email", email);
			
			//Get the name of the user from the database
			String name = query.get_name(request, response, email);
			session.setAttribute("name", name);
			
			//Send the user to the homepage upon login
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			try {
				System.out.println("Entered");
				dispatcher.forward(request,response);
			} catch (ServletException e1) {
				System.out.println("Entered2");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Entered3");
				e1.printStackTrace();
			}
		} else {
			//The user provided the wrong password.
			nextJSP = "login.jsp";
			
		}
	}
	
	/**
	 * Go to verify login
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Reached doGet of Login_Servlet");
			try {
				verify_login(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	/**
	 * Go to doGet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
