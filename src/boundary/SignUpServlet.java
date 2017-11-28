package boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		
		String code = generateCode();
		//int x = db.addNewUser(name, email, password, phone, shippingAddress, billingAddress);
		
		sendEmail(email, code);
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
	
	/*
     * Method for sending confirmation email
     * reference:
     * https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
     */
    protected void sendEmail(String email, String code) {
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
			message.setSubject("Welcome to the Bookstore!");
			message.setText("Your verification code is " + code);

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
