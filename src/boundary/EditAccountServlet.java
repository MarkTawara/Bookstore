package boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class EditAccountServlet
 */
@WebServlet("/EditAccountServlet")
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		String session_email = (String)sesh.getAttribute("email");
		
		bookstore_query db = new bookstore_query();
		
		String firstname, lastname, name, email, password, phone, shippingAddress,  billingAddress, cardtype, cardnum, expdate;
		firstname = lastname = name = email = password = phone = shippingAddress = billingAddress = cardtype = cardnum = expdate = "";
		int isSubscribed = -1;
		
		String form = request.getParameter("form_number");
		
		if(form.equals("1")) {
			firstname = request.getParameter("firstname").trim();
			lastname = request.getParameter("lastname").trim();
			if (firstname.length() > 0 && lastname.length() > 0) {
				name = firstname + " " + lastname;
			}
			email = request.getParameter("email").trim();
			password = request.getParameter("password");
			phone = request.getParameter("phonenum").trim();
			if (request.getParameter("subscribed").length() > 0) {
				isSubscribed = Integer.parseInt(request.getParameter("subscribed"));
			}
			 
		}

		else if(form.equals("2")) {
			System.out.println(form);
			String shipStreet = request.getParameter("street").trim();
			String shipCity = request.getParameter("city").trim();
			String shipState = request.getParameter("state").trim();
			String shipZip = request.getParameter("zip").trim();
			shippingAddress = shipStreet + " " + shipCity + " " + shipState + " " + shipZip;
		}
		else if(form.equals("3")) {
			cardtype = request.getParameter("cardtype");
			cardnum = request.getParameter("cardnum").trim();
			expdate = request.getParameter("expireMM") + "/" + request.getParameter("expireYY");
		}
		else if(form.equals("4")) {
			String billStreet = request.getParameter("street2").trim();
			String billCity = request.getParameter("city2").trim();
			String billState = request.getParameter("state2").trim();
			String billZip = request.getParameter("zip2").trim();
			billingAddress = billStreet + " " + billCity + " " + billState + " " + billZip;
		}
		
		//System.out.println("stuff " + firstname + lastname + name + email + password + phone + shippingAddress + billingAddress + cardtype + cardnum + expdate);
		
		if ((email.length() > 0) && db.isEmailAlreadyRegistered(email)) { // if email already exists
			request.setAttribute("errorMessage", "Email is already registered.");
			request.removeAttribute("saveMessage");
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/editAccount.jsp");
			dispatcher.forward(request, response);	
		}
		else {
			db.editUser(session_email, name, email, password, phone, shippingAddress, billingAddress, cardtype, cardnum, expdate, isSubscribed);
			//request.removeAttribute("errorMessage");
			request.setAttribute("saveMessage", "Changes have been saved.");
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/editAccount.jsp");
			dispatcher.forward(request, response);
		}
	}

}
