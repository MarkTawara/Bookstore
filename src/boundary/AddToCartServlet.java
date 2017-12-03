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
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		bookstore_query query = new bookstore_query();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		ArrayList list = new ArrayList();
		
		//Get info from the page
		String email = "";
		String isbn = request.getParameter("param");
		int quantity = Integer.parseInt(request.getParameter("qty"));
		int quantityInStore=0;
		
		if(session.getAttribute("email")!=null){ //User is logged in - good
			email = session.getAttribute("email").toString();
			//First, check to make sure the book's quantity in the store is > the amount ordered
			quantityInStore = query.checkQuantityInStore(isbn);
			if(quantityInStore >= quantity){ //If bookstoreQuantity>quantityOrdered -> user can order this.
				System.out.println("User can order");
				query.addToCart(email, isbn, quantity);
				dispatcher = request.getRequestDispatcher("SearchBooksServlet");
				dispatcher.forward(request, response);
			}else{ //User can't order this many books, alert them with quantity that we have
				System.out.println("User can't oder");
				list = query.getBookInfo(isbn);
				request.setAttribute("book", list);
				dispatcher = request.getRequestDispatcher("/notEnoughInStock.jsp");
				dispatcher.forward(request, response);
			}
		}else{ //Make user sign in or create an account first.
			dispatcher = request.getRequestDispatcher("/allBooksFail.jsp");
			dispatcher.forward(request, response);
		}		
	}

}
