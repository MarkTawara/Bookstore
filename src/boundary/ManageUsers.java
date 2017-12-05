package boundary;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;
import object.Book;
//import logic_layer.Logic;
import object.Order;
import object.User;

@WebServlet("/ManageUsers")
public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String globalEmail = "";

	/**
	 * Constructor
	 */
	public ManageUsers() {
		super();
	}

	
	/**
	 * Verify the login credentials. Send user to index.jsp on success, and ___ on failure
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		bookstore_query query = new bookstore_query();
		ArrayList<User> users = new ArrayList<>();
		
		users = query.getAllUsers();
		
		request.setAttribute("userResults", users);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/manageUser.jsp");
		dispatcher.forward(request, response);
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("param");
		bookstore_query query = new bookstore_query();
		
		if (query.deleteUser(email)) { // Deleted succesfully
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/adminView.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { //Failed to delete
			System.out.println("failed to delete the user");
		}
	}
	
	public void suspendUser(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("param");
		bookstore_query query = new bookstore_query();
		
		if (query.suspendUser(email)) { // Deleted succesfully
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/adminView.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { //Failed to delete
			System.out.println("failed to delete the user");
		}
	
	}
	
	/**
	 * Go to verify login
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				if (request.getParameter("delete") != null) {
					deleteUser(request, response);
				} else if (request.getParameter("suspend") != null) {
					suspendUser(request, response);
				} else {
					getUsers(request, response);
				}
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
