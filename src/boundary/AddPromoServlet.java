package boundary;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class AddPromoServlet
 */
@WebServlet("/AddPromoServlet")
public class AddPromoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String code = request.getParameter("promoCode");
		String expDate = request.getParameter("date");
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(expDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int discount = Integer.parseInt(request.getParameter("discount"));
		
		bookstore_query query = new bookstore_query();
		query.addPromo(code, date, discount);
		
		dispatcher = request.getRequestDispatcher("/promoAdded.jsp");
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
