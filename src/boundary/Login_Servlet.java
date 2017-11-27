package boundary;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

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
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_Servlet() {
		super();
	}

	public void verify_login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String email = request.getParameter("reg_email");
		String password = request.getParameter("reg_password");
		
		bookstore_query query = new bookstore_query();
		
		boolean checkLogin = query.validate_user(request, response, email, password);
		if (checkLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			String name = query.get_name(request, response, email);
			session.setAttribute("name", name);
			System.out.println("Fuck This " + name);
		} else {
			System.out.println("Still Fuck This");
		}
		
		/*
		if (bookstore_query.validate_user(request, response, email, password)) {
			
		}*/
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("hello");
			try {
				verify_login(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			catch (SQLException e) {
				e.printStackTrace();
			}
			 */
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
