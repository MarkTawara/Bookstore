package boundary;

import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.bookstore_query;
import object.Promotion;

/**
 * Servlet implementation class PreCheckoutServlet
 */
@WebServlet("/PreCheckoutServlet")
public class PreCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreCheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		bookstore_query query = new bookstore_query();
		DecimalFormat df2 = new DecimalFormat(".##");
		Calendar c = Calendar.getInstance();
		Calendar tempCal = Calendar.getInstance();
		double pOff = 0;
		//Get promo code
		double price = Double.parseDouble(request.getParameter("priceInCart"));
		String promo = request.getParameter("promo");
		if(promo.equals("")){ //No promo code entered, continue normally
			dispatcher = request.getRequestDispatcher("/checkout.jsp");
			request.setAttribute("finalPrice", price);
			dispatcher.forward(request, response);
		}else{ //Promo code was entered
			//Check if promo code is valid
			Promotion p = query.isPromotionValid(promo);
			java.util.Date d = p.getDate();
			tempCal.setTime(d);
			if(p.getCode()!=null && (tempCal.compareTo(c)>0 || tempCal.compareTo(c)==0)){
				//Code was valid, update price
				pOff = price * (p.getPercentOff()*.01);
				price = price - pOff;
				dispatcher = request.getRequestDispatcher("/checkout.jsp");
				request.setAttribute("finalPrice", df2.format(price));
				dispatcher.forward(request, response);
			}else{
				//Promo code not valid, let the user know.
				request.setAttribute("checkoutBool", "false");
				ServletContext context= getServletContext();
				dispatcher = context.getRequestDispatcher("/DisplayCartServlet");
				dispatcher.forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
