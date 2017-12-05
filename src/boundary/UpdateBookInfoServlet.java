package boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class UpdateBookInfoServlet
 */
@WebServlet("/UpdateBookInfoServlet")
public class UpdateBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/editBooks.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstore_query db= new bookstore_query();
		String title, author, isbn, publisher, publication_year, description;
		double price;
		int edition, qty_in_stock;
		
		title = request.getParameter("title").trim();
		author = request.getParameter("author").trim();
		isbn = request.getParameter("isbn").trim();
		publisher = request.getParameter("publisher").trim();
		publication_year = request.getParameter("publication_year").trim();
		description = request.getParameter("descr").trim();
		price = Double.parseDouble(request.getParameter("price"));
		edition = Integer.parseInt(request.getParameter("edition"));
		qty_in_stock = Integer.parseInt(request.getParameter("qty_in_stock"));
		
		db.updateBook(title, author, isbn, publisher, publication_year, description, price, edition, qty_in_stock);
		doGet(request, response);
	}

	
}
