package boundary;

import java.io.IOException;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstore_query db = new bookstore_query();
		String business_type, business_name, street, city, state, zip, business_phone, contact_name, email, workphone, cellphone;
		
		business_type = request.getParameter("business_type");
		business_name = request.getParameter("business_name");
		street = request.getParameter("street");
		city = request.getParameter("city");
		state = request.getParameter("state");
		zip = request.getParameter("zip");
		String business_address = street + " " + city + " " + state + " " + zip;
 		business_phone = request.getParameter("businessphone");
		contact_name = request.getParameter("contact_name");
		email = request.getParameter("email");
		workphone = request.getParameter("workphone");
		cellphone = request.getParameter("cellphone");
		
		db.addSupplierOrShipment(business_type, business_name, business_address, business_phone, contact_name, email, workphone, cellphone);
		
		doGet(request, response);
	}

}
