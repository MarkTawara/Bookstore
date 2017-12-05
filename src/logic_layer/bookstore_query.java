package logic_layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import object.Book;
import object.Order;
import object.Promotion;
import persist_layer.DB_Access;

public class bookstore_query {
	
	/*
	 * This method is called from the Login_Servlet, and it creates a query to that is executed to enter a new user into the database.
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
	
	public static String getBookNames(int orderID){
		String query = "SELECT b.title FROM book b, orderItems oi where oi.order_id='"+orderID+"' and oi.product_isbn=b.isbn;";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		String bookList = "";
		int count = 0;
		try{
			rs = DB_Access.retrieve(con, query);
			while(rs.next()){
				if(count==0){
					bookList = rs.getString(1);
					count++;
				}else{
					bookList = bookList + ", " + rs.getString(1);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		return bookList;
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
		System.out.println(description);
		String query = "INSERT INTO book (price, isbn,  title, author, edition, publisher, publication_year, description, quantity_in_stock)\n" + 
				"VALUES (" + price + ", '" + isbn + "', '" + title +  "', '" + author + "', " + edition + ", '" + publisher + "', '" + publication_year + "', \"" + description + "\", " +  quantity_in_stock + ")";
		int r = 0;
		try{
			r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void addImage(String isbn, Part image) {
		String sql = "UPDATE book set cover_picture=?" +  " where isbn = '"+isbn+"'";
		PreparedStatement myStmt = null;
		Connection con = null;
		int result = 0;
		
		 System.out.println(image);
		
		try {
			con = DB_Access.connect();
			myStmt = con.prepareStatement(sql);
			
			InputStream is = image.getInputStream();
			myStmt.setBlob(1, is);
			
			result = myStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//DB_Access.disconnect(con);
		
		if (result > 0) {
			System.out.println("worked");
		} else {
			System.out.println("failed");
		}
	}
	
	/*
	 * This methods is called from AddToCartServlet to update a user's cart
	 */
	public void addToCart(String email, String isbn, int quantity) { 
		String query = "INSERT INTO `bookStore`.`cart` (`email`, `isbn`, `quantity`) VALUES ('"+email+"', '"+isbn+"', '"+quantity+"');";
		int r=0;
		try{
			r=DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public ArrayList<Order> getUserOrders(String email){
		
		ArrayList list = new ArrayList();
		String query = "select * from orders where customer = '"+email+"';";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		rs = DB_Access.retrieve(con, query);
		try{
			while(rs.next()){
				Order o = new Order(rs.getInt(1), rs.getDate(2), rs.getDouble(5), rs.getString(4));
				list.add(o);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
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
	 * removes all books from the user's shopping cart
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
	
	//Check if the promotion is legit
	public Promotion isPromotionValid(String promo){
		Promotion p = new Promotion();
		String promoQuery = "select * from promotion where code='" + promo+"';";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		try{
			rs=DB_Access.retrieve(con, promoQuery);
			if(rs.next()){//Promotion of this code was found
				p.setCode(rs.getString(2));
				p.setPercentOff(rs.getInt(4));
				p.setDate(rs.getDate(3));
			}else{//Promotion not found
				return p;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}
	
	//Add an order to the database
	public int completeOrder(String email, double price){
		//Create one row in the Orders table
		String paymentType="";
		String billingAddress="";
		String shippingAddress="";
		String userQuery = "select * from registered_customer where email='"+email+"';";
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		try{
			rs = DB_Access.retrieve(con, userQuery);
			if(rs.next()){
				paymentType=rs.getString(9);
				billingAddress=rs.getString(3);
				shippingAddress=rs.getString(5);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		String orderQuery = "INSERT INTO `bookStore`.`orders` (`order_date`, `customer`, `status`, `total_price`, `payment_method`, `billing_address`, `shipping_address`) VALUES"
				+ " (NOW(), '"+email+"', 'processing', '"+price+"', '"+paymentType+"', '"+billingAddress+"', '"+shippingAddress+"');";
		int rows=0;
		try{
			rows=DB_Access.insert(orderQuery);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		//Now add all the books from the order to the orderItems table
		int orderID = 0;
		String orderIDQuery = "select order_id from orders where customer='"+email+"' and order_date=NOW() and total_price='"+price+"';";
		ResultSet id = DB_Access.retrieve(con, orderIDQuery);
		try {
			if(id.next()){
				orderID = id.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String cartQuery = "select c.* from cart c, registered_customer rc where c.email=rc.email and rc.email ='" + email + "';";
		String quantityInStockQuery = "";
		String orderItemsQuery = "";
		String isbn = "";
		int quantity = 0;
		rows=0;
		int rows2=0;
		ResultSet cart = DB_Access.retrieve(con, cartQuery);
		//iterate through all the books to add
		try{
			while(cart.next()){
				//Put each isbn and quantity into the orderItems table
				quantity = cart.getInt(3);
				isbn = cart.getString(2);
				System.out.println("Quantity: "+quantity+ " ISBN: " + isbn);
				//Be sure to decrease quantity in store
				quantityInStockQuery = "update book set quantity_in_stock = quantity_in_stock-'"+quantity+"' where isbn='"+isbn+"' and quantity_in_stock>0;";
				orderItemsQuery = "INSERT INTO `bookStore`.`orderItems` (`order_id`, `product_isbn`, `quantity`) VALUES ('"+orderID+"', '"+isbn+"', '"+quantity+"');";
				rows=DB_Access.update(orderItemsQuery);
				rows2=DB_Access.update(quantityInStockQuery);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("FINISHED COMPLETE ORDER");
		return orderID;
	}
	
	public Order getOrder(int orderID){
		String getOrderQuery = "select * from orders where order_id = '"+orderID+"';";
		Order o = new Order();
		Connection con = DB_Access.connect();
		ResultSet rs = DB_Access.retrieve(con, getOrderQuery);
		try {
			if(rs.next()){
				o.setDateOrderedReal(rs.getDate(2));
				o.setShippingAddress(rs.getString(8));
				o.setTotalPrice(rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
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
	 * used in editBooks.jsp
	 */
	public ResultSet getBooks() {
		String query = "SELECT * from book";
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
				byte[] imgData = rs.getBytes("cover_picture"); // blob field 
				String encode = Base64.getEncoder().encodeToString(imgData);
				
				Book book = new Book(rs.getString(5), rs.getString(3), rs.getDouble(4), rs.getString(2), encode, rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), 0, rs.getString(13));
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
				byte[] imgData = rs.getBytes("cover_picture"); // blob field 
				String encode = Base64.getEncoder().encodeToString(imgData);
				
				Book book = new Book(rs.getString(5), rs.getString(3), rs.getDouble(4), rs.getString(2), encode, rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), 0, rs.getString(13));
				list.add(book);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		System.out.println("FINISHED GETTING BOOKS BY KEYWORD");
		return list;
	}
	
	public ArrayList<Book> getBooksAdvanced(String title, String author, String isbn, String subject){
		//This array list will hold all of the Book objects in one list.
		ArrayList<Book> list = new ArrayList<Book>();
		ResultSet rs = null; //Holds Cart table info
		Connection con = DB_Access.connect();
		//Get the info from the cart table		
		String bookQuery = "select * from book where ";
		ArrayList<String> queryList = new ArrayList<String>();
		
		if(!title.equals("")) {
			queryList.add("title like '%" + title + "%'");
		}
		if(!author.equals("")) {
			queryList.add("author like '%" + author + "%'");
		}
		if(!isbn.equals("")) {
			queryList.add("isbn like '%" + isbn + "%'");
		}
		if(!subject.equals("")) {
			queryList.add("subject like '%" + subject + "%'");
		}
		
		for(String s : queryList) {
			bookQuery += s + " and ";
		}		
		rs = DB_Access.retrieve(con, bookQuery.substring(0,bookQuery.length()-5));
		System.out.println(bookQuery.substring(0,bookQuery.length()-5));
		try{
			while(rs.next()){
				byte[] imgData = rs.getBytes("cover_picture"); // blob field 
				String encode = Base64.getEncoder().encodeToString(imgData);
				
				Book book = new Book(rs.getString(5), rs.getString(3), rs.getDouble(4), rs.getString(2), encode, rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10), 0, rs.getString(13));
				list.add(book);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		DB_Access.disconnect(con);
		System.out.println("FINISHED GETTING BOOKS BY KEYWORD");
		return list;
	}
	
	public int checkQuantityInStore(String isbn){
		int q = 0;
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		String checkQuantityQuery = "select quantity_in_stock from book where isbn= '" + isbn + "'";
		rs = DB_Access.retrieve(con, checkQuantityQuery);
		try {
			if(rs.next()){
				q = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return q;
	}
	
	public ArrayList<Book> getBookInfo(String isbn){
		ArrayList list = new ArrayList();
		Book b = new Book();
		ResultSet rs = null;
		Connection con = DB_Access.connect();
		String checkQuantityQuery = "select * from book where isbn= '" + isbn + "'";
		rs = DB_Access.retrieve(con, checkQuantityQuery);
		try {
			if(rs.next()){
				b.setTitle(rs.getString(2));
				b.setQuantityInStock(Integer.parseInt(rs.getString(11)));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void removeBookFromDb(String title) {
		String query = "DELETE from book WHERE title='" + title + "'";
		try{
			DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ResultSet getBookFromDb(String title) {
		String query = "SELECT * from book WHERE title = '" + title + "'";
		Connection con = DB_Access.connect();
		ResultSet rs = DB_Access.retrieve(con, query);
		return rs;
	}
	
	public void updateBook(String title, String author, String isbn, String publisher, String publication_year, String description, double price, int edition, int qty_in_stock) {
		String query = "UPDATE book SET ";
		if(author.length() > 0) {
			query += " author = '" + author + "',";
		}
		if(isbn.length() > 0) {
			query += " isbn = '" + isbn + "',";
		}
		if(publisher.length() > 0) {
			query += " publisher = '" + publisher + "',";
		}
		if(publication_year.length() > 0) {
			query += " publication_year = '" + publication_year + "',";
		}
		if(description.length() > 0) {
			query += " description = '" + description + "',";
		}
		if(price > 0) {
			query += " price = " + price + ",";
		}
		if(edition > 0) {
			query += " edition = " + edition + ",";
		}
		if(qty_in_stock > 0) {
			query += " quantity_in_stock = " + qty_in_stock + ",";
		}
		query = query.substring(0, query.length()-1);
		query += " WHERE title = '" + title + "'";
		//System.out.println(query);
		
		try{
			DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addSupplierOrShipment(String business_type, String business_name, String business_address, String business_phone, String contact_name, String email, String workphone, String cellphone) {
		String query = "INSERT INTO " + business_type + " (business_name, business_address, business_phone, contact_name, email, workphone, cellphone)" + 
				" VALUES ('" + business_name + "', '" + business_address + "', '" + business_phone + "', '" + contact_name + "', '" + email + "', '" + workphone + "', '" + cellphone + "')";
		//System.out.println(query);
		
		try{
			int r = DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ResultSet getSuppliersOrShipment(String business_type) {
		String query = "SELECT * from ";
		if (business_type.equals("shipping_agency")) {
			query += "shipping_agency";
		}
		else {
			query += "supplier";
		}
		Connection con = DB_Access.connect();
		ResultSet rs = DB_Access.retrieve(con, query);
		return rs;
	}

	public void removeShipmentFromDb(String business_type, String business_name) {
		String query = "DELETE from " + business_type + " WHERE business_name" + "='" + business_name + "'";
		System.out.println(query);
		try{
			DB_Access.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void addPromo(String code, Date date, int discount){
		String query = "INSERT INTO `bookStore`.`promotion` (`code`, `exp_date`, `percentage`) VALUES (?, ?, ?)";
		Connection con = DB_Access.connect();
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, code);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			ps.setInt(3, discount);
			ps.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public ResultSet getOrdersReport(String startDate, String endDate) {
		String query = "SELECT * FROM orders WHERE order_date >= " + startDate + " AND order_date < " + endDate;
		Connection con = DB_Access.connect();
		ResultSet rs = DB_Access.retrieve(con, query);
		//DB_Access.disconnect(con);
		
		return rs;
	}
	
}
