package boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditShipmentAgencyServlet
 */
@WebServlet("/EditShipmentAgencyServlet")
public class EditShipmentAgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShipmentAgencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/updateShipmentAgency.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String business_name = request.getParameter("business_name");
		String business_type = request.getParameter("business_type");
		//System.out.println(business_type);
		//System.out.println(business_name);
		request.setAttribute("business_name", business_name);
		request.setAttribute("business_type", business_type);
		doGet(request, response);
	}

}
