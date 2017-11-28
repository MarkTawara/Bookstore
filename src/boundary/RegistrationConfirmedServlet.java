package boundary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class RegistrationConfirmedServlet
 * Checks the validation code sent after sign up and set account status to active
 */
@WebServlet("/RegistrationConfirmedServlet")
public class RegistrationConfirmedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String message = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationConfirmedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("/WEB-INF/confirm_account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstore_query db = new bookstore_query();
		
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		String actualCode = (String)session.getAttribute("code");
		String inputCode = request.getParameter("inputcode").trim();
		
		if (actualCode.equals(inputCode)) {
			message = "Your account has been confirmed! Redirecting to sign-in page... <META http-equiv=\"refresh\" content=\"3;URL=login.html\">";
			session.invalidate();
			db.changeAccountStatus(email, "Active");
		}
		else {
			message = "Validation code is incorrect.";
		}
		doGet(request, response);
	}

}
