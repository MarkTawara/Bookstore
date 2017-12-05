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
//import logic_layer.Logic;
import object.Order;

@WebServlet("/GetReports")
public class GetReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String globalEmail = "";

	/**
	 * Constructor
	 */
	public GetReports() {
		super();
	}

	
	/**
	 * Verify the login credentials. Send user to index.jsp on success, and ___ on failure
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void verify_login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		bookstore_query query = new bookstore_query();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		double total_price = 0;
		
		String startDate = "'" + year + "-" + month + "-" + day + " 00:00:00'";
		String endDate = "'" + year + "-" + month + "-" + (day + 1) + " 00:00:00'";
		String curDate = month + "/" + day + "/" + year;
		
		ResultSet rs = query.getOrdersReport(startDate, endDate);
		ArrayList<Order> orders = new ArrayList<>();
		
		while (rs.next()) {
			System.out.println(curDate);
			total_price += rs.getDouble("total_price");
			Order order = new Order(rs.getInt("order_id"), rs.getString("customer"), curDate, rs.getDouble("total_price"));
			orders.add(order);
		}
		
		request.setAttribute("orderResults", orders);
		request.setAttribute("totalPrice", total_price);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/pullReports.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Go to verify login
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
