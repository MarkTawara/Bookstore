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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("registration_confirmation.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bookstore_query db = new bookstore_query();
		
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String name = firstname + " " + lastname;
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password");
		String phone = request.getParameter("phonenum").trim();
		boolean isSubscribed = Boolean.parseBoolean(request.getParameter("subscribed"));
		
		String shipStreet = request.getParameter("street").trim();
		String shipCity = request.getParameter("city").trim();
		String shipState = request.getParameter("state").trim();
		String shipZip = request.getParameter("zip").trim();
		String shippingAddress = shipStreet + " " + shipCity + " " + shipState + " " + shipZip;
		
		String billingAddress;
		if (request.getParameter("billingEqualsShipping") == "true") {
			billingAddress = shippingAddress;
		}
		else {
			String billStreet = request.getParameter("street2").trim();
			String billCity = request.getParameter("city2").trim();
			String billState = request.getParameter("state2").trim();
			String billZip = request.getParameter("zip2").trim();
			billingAddress = billStreet + " " + billCity + " " + billState + " " + billZip;
		}
		
		String cardtype = request.getParameter("cardtype");
		String cardnum = request.getParameter("cardnum").trim();
		String expdate = request.getParameter("expireMM") + "/" + request.getParameter("expireYY");
		String ccv = request.getParameter("ccv").trim();
		
		int x = db.addNewUser(name, email, password, phone, shippingAddress, billingAddress);
		
		doGet(request, response);
	}

}
