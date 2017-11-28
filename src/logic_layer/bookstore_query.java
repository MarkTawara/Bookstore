package logic_layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	public static String get_name(HttpServletRequest request, HttpServletResponse response, String email) {
		String query = "SELECT customer_name FROM registered_customer WHERE email = '"+email+"'";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if successfully login
				return rs.getString("customer_name");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	

			
		DB_Access.disconnect(con);
		return "fucking Fucking Fucking FUCKING SHIBAL";
	}
	
	/*
	 * This method is called from AddBook to add a new book to the database
	 */
	public void addBook(String title, String author, double price, String description, byte[] image) {
		String query = "TBDDDDD";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		
		try{
			rs = DB_Access.retrieve(con, query);
			if (rs.next()) { // enter here if successfully login
				//return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	

			
		DB_Access.disconnect(con);
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
	public int addNewUser(String name, String email, String password, String phone, String shippingAddress, String billingAddress,String cardtype, String cardnum, String expdate) {
		String query = "INSERT INTO registered_customer (customer_name, billing_address, email, shipping_address, phone_number, password, card_type, card_num, card_exp_date)\n" + 
				"VALUES ('" + name + "', '" + billingAddress + "', '" + email + "', '" + shippingAddress + "', '" + phone + "', '" + password + "', '" + cardtype + "', '" + cardnum + "', '" + expdate + "')";

		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
	
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
	
}