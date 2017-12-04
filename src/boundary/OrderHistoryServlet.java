package boundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;
import object.Book;
import object.Order;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		bookstore_query query = new bookstore_query();
		String email = session.getAttribute("email").toString();
		Book b = new Book();
		Order o = new Order();
		Map<Long, String> bookTitles = new HashMap<Long, String>();
		int orderID = 0;
		String tempBookTitle = "";
		
		//First, get a list of orders made by the user
		ArrayList list = new ArrayList();
		list = query.getUserOrders(session.getAttribute("email").toString());
		request.setAttribute("orders", list);
		
		String queryTitles = "";

		//Then get a list of the books in the orders

		for(int i=0; i<list.size(); i++){ //For each order...
			o = (Order)list.get(i);
			orderID = o.getOrderId();
			queryTitles = query.getBookNames(orderID);
			o.setTitleList(queryTitles);
		}
		
		request.setAttribute("titles", bookTitles);
		dispatcher = request.getRequestDispatcher("/order_history.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
