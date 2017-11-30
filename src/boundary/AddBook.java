package boundary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
@MultipartConfig
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddBook() {
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
		//Create a Logic class to use & Send queries to.
		bookstore_query base = new bookstore_query();
		
		//All Get Parameter methods retrieve information from the HTML page.
		//The getParameter parameter corresponds with the 'name' tag in html.
		String title = request.getParameter("bookTitle");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("descr");
		String isbn = request.getParameter("isbn");
		int edition = Integer.parseInt(request.getParameter("edition"));
		String publisher = request.getParameter("publisher");
		String publication_year = request.getParameter("publication_year");
		int quantity_in_stock = Integer.parseInt(request.getParameter("qty_in_stock"));
		/**
		 * The 'Part' 'fileName' and 'InputStream' are needed for uploading an image.
		 * The next few lines of code convert the InputStream of the 
		 * image contents into a byte array, which we can upload to 
		 * the database as a BLOB type. 
		 */
		Part filePart = request.getPart("image");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for(int length=0; (length=fileContent.read(buffer)) > 0;) {
			output.write(buffer, 0, length);
		}
		
		//Now send information collected to the logic using a method
		base.addBook(title, author, price, isbn, edition, publisher, publication_year, description, quantity_in_stock, output.toByteArray());
		
		doGet(request, response);
	}

}
