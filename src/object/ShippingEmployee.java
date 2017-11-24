package object;

public class ShippingEmployee extends User{

	//Variables
	String email;
	String password;
	
	//Default constructor
	public ShippingEmployee() {
		super();
	}
	
	//Constructor
	public ShippingEmployee(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	//Lets the shipping employee update the order status of an order
	public void updateOrderStatus(){
		
	}
	
	//Getters & Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
