package logic_layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Book;
import persist_layer.DB_Access;

public class bookstore_query {
	
	/*
	 * This method is called from the Login_Servlet, and it creates a query to that is executed to enter a new user into the database.
	 * ???????????????????????????? what is this
	 */
	public static int insert_new_user(HttpServletRequest request, HttpServletResponse response, String name, String email, String password) {
		String query = "INSERT INTO users (name, email, password) Values('"+name+"', '"+email+"', '"+password+"')";
		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
	
	/*
	 * This method is called from Login_Servlet to check if the user exists and allows the user to log in
	 */
	public static boolean validate_user(HttpServletRequest request, HttpServletResponse response, String email, String password) {
		String query = "SELECT 1 FROM registered_customer WHERE email = '"+email+"' AND password = '"+password+"'";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if successfully login
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
		DB_Access.disconnect(con);
		return false;
	}
	
	/*
	 * This method is called from Login_Servlet to add get the name of the user based on their email login
	 */
	public static String get_name(HttpServletRequest request, HttpServletResponse response, String email) {
		String query = "SELECT customer_name FROM registered_customer WHERE email = '"+email+"'";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if successfully gotten the customer name
				return rs.getString("customer_name");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}		
		DB_Access.disconnect(con);
		return "Error in get_name() in bookstore_query.java";
	}
	
	/*
	 * This method is called from Login_Servlet to add get the name of the user based on their email login
	 */
	public static String get_type(String email) {
		String query = "SELECT account_type FROM registered_customer WHERE email = '"+email+"'";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if successfully gotten the customer account type
				return rs.getString("account_type");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}		
		DB_Access.disconnect(con);
		return "Error in get_name() in bookstore_query.java";
	}
	
	/*
	 * This method is called from AddBook to add a new book to the database
	 */
	public void addBook(String title, String author, double price, String isbn, int edition, String publisher, String publication_year, String description, int quantity_in_stock, byte[] image) {
		String query = "INSERT INTO book (price, isbn,  title, author, edition, publisher, publication_year, description, quantity_in_stock)\n" + 
				"VALUES (" + price + ", '" + isbn + "', '" + title +  "', '" + author + "', " + edition + ", '" + publisher + "', '" + publication_year + "', '" + description + "', " +  quantity_in_stock + ")";
		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//return r;
	}
	
	/*
	 * This methods is called from AddToCartServlet to update a user's cart
	 */
	public void addToCart(String user, String cartID, String isbn, int qty) { 
		// TODO this
	}
	
	/*
	 * This method is called from SignUpServlet to add a new user to the db
	 */
	public int addNewUser(String name, String email, String password, String phone, String shippingAddress, String billingAddress,String cardtype, String cardnum, String expdate, int isSubscribed, String accountType) {
		String query = "INSERT INTO registered_customer (customer_name, billing_address, email, shipping_address, phone_number, password, card_type, card_num, card_exp_date, is_subscribed, account_type)\n" + 
				"VALUES ('" + name + "', '" + billingAddress + "', '" + email + "', '" + shippingAddress + "', '" + phone + "', '" + password + "', '" + cardtype + "', '" + cardnum + "', '" + expdate + "', '" + isSubscribed + "', '" + accountType + "')";
		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
	
	/*
	 * Changes account status (active, suspended, etc)
	 */
	public int changeAccountStatus(String email, String status) {
		String query = "UPDATE registered_customer SET account_status = '" + status + "' WHERE email = '" + email + "'";
		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
	
	//After a user submits an email for a forgotten password
	//The database is updated to reflect the random password that was generated
	public int changePassword(String email, String password){
		int r = 0;
		String query = "UPDATE registered_customer SET password = '" + password + "' WHERE email = '" + email +"'";
		try {
			r=DB_Access.insert(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	/*
	 * Check if email already exists in database
	 */
	public boolean isEmailAlreadyRegistered(String email) {
		String query = "SELECT customer_name FROM registered_customer WHERE email = '"+email+"'";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if email exists
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

		DB_Access.disconnect(con);
				
		return false;
	}
	
	public ArrayList<Book> getUserCart(String email){
		//This array list will hold all of the Book objects in one list.
		ArrayList list = new ArrayList();
		//This Map maps together the quantity of books ordered (of the same isbn) and the ISBN of the books in the cart
		Map<Integer, String> hm = new HashMap<Integer, String>();
		ResultSet rs = null; //Holds Cart table info
		ResultSet rs2 = null; //Holds Book table info
		Connection con = DB_Access.connect();
		//Get the info from the cart table
		String cartQuery = "select c.* from cart c, registered_customer rc where c.email=rc.email and rc.email ='" + email + "';";
		String bookQuery;
		rs = DB_Access.retrieve(con, cartQuery);
		int quantity=0;
		String isbn = "";
		
		try{
			while(rs.next()){
				//Put(Quantity, ISBN)
				quantity = rs.getInt(3);
				isbn = rs.getString(2);
				hm.put(quantity, isbn);
				//While we can still get the ISBN from getString(2), call another query
				bookQuery = "select * from book where isbn= '"+ isbn + "';";
				rs2 = DB_Access.retrieve(con, bookQuery);
				if(rs2.next()){
					Book books = new Book(rs2.getString(5), rs2.getString(3), rs2.getDouble(4), rs2.getString(2), rs2.getInt(7), rs2.getString(8), rs2.getInt(9), rs2.getString(10), quantity);
					list.add(books);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		System.out.println("FINISHED DISPLAY CART");
		return list;
	}
	
	/*
	 * removes a book from the user's shopping cart
	 */
	public void removeBookFromCart(String email, String isbn, int quantity){
		//Remove the book from the cart
		String removeQuery = "delete from cart where email= '" + email+ "' and isbn='"+isbn+"' and quantity='"+quantity+"';";
		System.out.println(quantity);
		int rows = 0;
		
		try{
			rows = DB_Access.update(removeQuery);
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("FINISHED REMOVE FROM CART");	
	}
	
	/*
	 * removes a book from the user's shopping cart
	 */
	public void emptyCart(String email){
		//Remove the book from the cart
		String removeQuery = "delete from cart where email= '" + email+"';";
		int rows = 0;
		
		try{
			rows = DB_Access.update(removeQuery);
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("FINISHED EMPTY CART");	
	}

	
	/*
	 * used in editAccount.jsp
	 */
	public ResultSet getUserInfo(String email) {
		String query = "SELECT * from registered_customer WHERE email = '" + email + "'";
		Connection con = DB_Access.connect();
		ResultSet rs = DB_Access.retrieve(con, query);
		return rs;
	}
	
	/*
	 *  used in editAccountServlet
	 */
	public int editUser(String session_email, String name, String email, String password, String phone, String shippingAddress, String billingAddress,String cardtype, String cardnum, String expdate, int isSubscribed) {
		int r = 0;
		String query = "UPDATE registered_customer SET ";
		if(name.length() > 0) {
			query += " customer_name = '" + name + "',";
		}
		if(email.length() > 0) {
			query += " email = '" + email + "',";
		}
		if(password.length() > 0) {
			query += " password = '" + password + "',";
		}
		if(phone.length() > 0) {
			query += " phone_number = '" + phone + "',";
		}
		if(shippingAddress.length() > 0) {
			query += " shipping_address = '" + shippingAddress + "',";
		}
		if(billingAddress.length() > 0) {
			query += " billing_address = '" + billingAddress + "',";
		}
		if(cardtype.length() > 0) {
			query += " card_type = '" + cardtype + "',";
		}
		if(cardnum.length() > 0) {
			query += " card_num = '" + cardnum + "',";
		}
		if(expdate.length() > 0) {
			query += " card_exp_date = '" + expdate + "',";
		}
		if(isSubscribed > -1) {
			query += " is_subscribed = " + isSubscribed + ",";
		}
		query = query.substring(0, query.length()-1);
		query += " WHERE email = '" + session_email + "'";
		//System.out.println(query);
		try {
			r=DB_Access.insert(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public ArrayList<Book> getAllBooks(){
		//This array list will hold all of the Book objects in one list.
		ArrayList<Book> list = new ArrayList<Book>();
		ResultSet rs = null; //Holds Cart table info
		Connection con = DB_Access.connect();
		//Get the info from the cart table
		String bookQuery = "select * from book";
		rs = DB_Access.retrieve(con, bookQuery);				
		try{
			while(rs.next()){
				Book book = new Book(rs.getString(5), rs.getString(3), rs.getDouble(4), rs.getString(2), rs.getBlob(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), 0);
				list.add(book);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		System.out.println("FINISHED GETTING ALL BOOKS");
		return list;
	}
	
	public ArrayList<Book> getBooksByKeyword(String keyword){
		//This array list will hold all of the Book objects in one list.
		ArrayList<Book> list = new ArrayList<Book>();
		ResultSet rs = null; //Holds Cart table info
		Connection con = DB_Access.connect();
		//Get the info from the cart table
		String bookQuery = "select * from book where title like '%" + keyword + "%'";
		rs = DB_Access.retrieve(con, bookQuery);				
		try{
			while(rs.next()){
				Book book = new Book(rs.getString(5), rs.getString(3), rs.getDouble(4), rs.getString(2), rs.getBlob(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), 0);
				list.add(book);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		System.out.println("FINISHED GETTING BOOKS BY KEYWORD");
		return list;
	}
}
