package boundary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class DisplayCartServlet
 */
@WebServlet("/DisplayCartServlet")
public class DisplayCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default Constructor
     */
    public DisplayCartServlet() {
        super();
    }

	/**
	 * Goes here first
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get user's current session
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		bookstore_query query = new bookstore_query();
		ArrayList list = new ArrayList();
		list = query.getUserCart(session.getAttribute("email").toString());
		request.setAttribute("books", list);
		if(request.getAttribute("checkoutBool") == null){
			request.setAttribute("checkoutBool", "true");
		}
		
		if(request.getAttribute("checkoutBool").equals("false")){
			//The checkout was a failure, so send to checkout fail page
			dispatcher = request.getRequestDispatcher("/checkoutFail.jsp");
			dispatcher.forward(request, response);	
		}else{
			//Normal stuff happens - display cart on shopping cart page
			dispatcher = request.getRequestDispatcher("/shoppingCart.jsp");
			dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
