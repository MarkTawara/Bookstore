package boundary;

import java.io.IOException;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bookstore_query db = new bookstore_query();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String name = firstname + " " + lastname;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phonenum");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String address = street + " " + city + " " + state + " " + zip;
		String cardtype = request.getParameter("cardtype");
		String cardnum = request.getParameter("cardnum");
		String expdate = request.getParameter("expireMM") + "/" + request.getParameter("expireYY");
		String ccv = request.getParameter("ccv");
		
		//db.addNewUser(name, email, password, phone, address);
		
	}

}
