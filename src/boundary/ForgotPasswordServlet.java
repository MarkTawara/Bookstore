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
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boolean existingEmail = true;   
	
    /**
     * Constructor
     */
    public ForgotPasswordServlet() {
        super();
    }

	/**
	 * Loads certain html pages upon request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//If there was an existing email show the user the failure page.
		if(existingEmail==false) {
			RequestDispatcher view = request.getRequestDispatcher("forgot_password_fail.html");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("forgot_password_confirmation.html");
			view.forward(request, response);	
		}
	}
	
	/**
	 * Comes to doPost first.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstore_query db = new bookstore_query();
		String email = request.getParameter("email").trim();
		String randomPassword = getSaltString();
			
		//CHANGE PASSWORD IN DATABASE TO MATCH randomPassword
		int changePW = db.changePassword(email, randomPassword);
		if(changePW == 0) {
			//No email existed in the database. Don't send an email
			existingEmail = false;
		}else {
			existingEmail = true;
			sendEmail(email, randomPassword);
		}
		//Load the html response pages
		doGet(request,response);	
	}
	
	//Reference: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
	//Creates a random password for the user
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	//Sends an email to the user with the new random password
	protected void sendEmail(String email, String randomPassword) {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Password Reset");
			message.setText("Your new password is " + randomPassword);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
