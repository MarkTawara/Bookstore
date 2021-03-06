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
 * Servlet implementation class AddSupplierOrShipmentAgency
 */
@WebServlet("/AddSupplierOrShipmentAgencyServlet")
public class AddSupplierOrShipmentAgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierOrShipmentAgencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/manageSuppliersAndShipment.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstore_query db = new bookstore_query();
		String business_type, business_name, street, city, state, zip, business_phone, contact_name, email, workphone, cellphone;
		
		business_type = request.getParameter("business_type").trim();
		business_name = request.getParameter("business_name").trim();
		street = request.getParameter("street").trim();
		city = request.getParameter("city").trim();
		state = request.getParameter("state").trim();
		zip = request.getParameter("zip").trim();
		String business_address = street + " " + city + " " + state + " " + zip;
 		business_phone = request.getParameter("businessphone").trim();
		contact_name = request.getParameter("contact_name").trim();
		email = request.getParameter("email").trim();
		workphone = request.getParameter("workphone").trim();
		cellphone = request.getParameter("cellphone").trim();
		
		db.addSupplierOrShipment(business_type, business_name, business_address, business_phone, contact_name, email, workphone, cellphone);
		
		doGet(request, response);
	}

}
