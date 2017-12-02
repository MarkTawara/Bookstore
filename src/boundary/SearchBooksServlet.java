package boundary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.bookstore_query;
import object.Book;

@WebServlet("/SearchBooksServlet")
public class SearchBooksServlet extends HttpServlet {
	private static final long serivalVersionUID = 1L;

	public SearchBooksServlet() {
		super();
	}

	/**
	 * Goes here first
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet SearchBooksServlet");
		bookstore_query query = new bookstore_query();		
		ArrayList<Book> books = query.getAllBooks();		
		request.setAttribute("results", books);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/all_books.jsp");
		dispatcher.forward(request, response);
		// Get user's current session
		// HttpSession session = request.getSession();
		// bookstore_query query = new bookstore_query();
		// ArrayList list = new ArrayList();
		// list = query.getUserCart(session.getAttribute("email").toString());
		// request.setAttribute("books", list);
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}