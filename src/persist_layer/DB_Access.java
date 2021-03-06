package persist_layer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB_Access {
	
	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	
	static final String CONNECTION_URL = "jdbc:mysql://bookstore.c94eoo8v7vjz.us-east-1.rds.amazonaws.com:3306/bookstore";
	
	static final String HOST_NAME = "bookstore.c94eoo8v7vjz.us-east-1.rds.amazonaws.com";
	
	static final String DB_CONNECTION_USERNAME = "root";
	
	static final String DB_CONNECTION_PASSWORD = "emanSaleh17";
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName(DRIVE_NAME);
			String jdbcUrl = "jdbc:mysql://" + HOST_NAME + ":" + "3306" + "/" + "bookStore" + "?user=" + "root" + "&password=" + "emanSaleh17";
		    con = DriverManager.getConnection(jdbcUrl);
			
			//con = DriverManager.getConnection(CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);
			System.out.println("Established a connection.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	} // end of connect
	
	//If rows = 0 after the code is ran, that means 0 rows were updated.
	public static int insert (String query){
		int rows = 0;
		try {
			Connection con = connect();
			java.sql.PreparedStatement stmt = con.prepareStatement(query);
			rows = stmt.executeUpdate();
			disconnect(con);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	//Use update when you want to remove a row or change data
	public static int update(String query){
		int rows=0;
		try{
			Connection con = connect();
			java.sql.PreparedStatement stmt = con.prepareStatement(query);
			rows=stmt.executeUpdate();
			disconnect(con);
			return rows;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public static ResultSet retrieve (Connection con, String query) {
		ResultSet rset = null;
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rset;
	}// end of retrieve
	
	public static void disconnect(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of closeConnection
}
