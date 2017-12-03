package boundary;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;
import object.Order;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		bookstore_query query = new bookstore_query();
		//Get variables from page
		double price = Double.parseDouble(request.getParameter("finalPrice"));
		String email = session.getAttribute("email").toString();
		
		//First, create an order entry in the database
		int orderID = query.completeOrder(email, price);
		
		//Next, send an order confirmation to the user's email.
		//Includes: customer name, confirmation #, order ID, order Date, shipping info, ordered items, and total price
		String confirmation = generateCode();
		Order o = query.getOrder(orderID);
		String customerName = query.get_name(request, response, email);
		String bookList = query.getBookNames(orderID);
		sendEmail(email, customerName, confirmation, orderID, o.getDateOrderedReal(), o.getShippingAddress(), bookList, o.getTotalPrice());
		
		//Next, remove all the items from the user's cart
		query.emptyCart(email);
		
		//Finally, show order confirmed page
		dispatcher = request.getRequestDispatcher("/order_confirmation.jsp");
		dispatcher.forward(request, response);	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected String generateCode() {
		Random rand = new Random();
		StringBuilder randomStr = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			randomStr.append(rand.nextInt(10));
		}
		return randomStr.toString();
	}
	
	protected void sendEmail(String email, String customerName, String confirmation, int orderID, Date date, String address, String bookList, double price) {
		final String username = "cs4050team10@gmail.com";
		final String password = "emanSaleh17";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cs4050team10@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Order confirmed");
			message.setText("Hello "+customerName+ ",\r\n We are confirming your order for the following books: "+bookList+". \r\n Your confirmation number is " + confirmation + ". Your orderID is "+orderID+". "
					+ "You ordered this on " + date+". The address it will be shipped to is "+address+". And finally, the total cost is $"+price+".\r\n Thank you for shopping with us!");

			Transport.send(message);
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
}

}
