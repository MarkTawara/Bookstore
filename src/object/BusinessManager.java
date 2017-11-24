package object;

public class BusinessManager extends User{

	//Variables
	String email;
	String password;
	
	//default constructor
	public BusinessManager() {
		super();
	}
	
	//constructor
	public BusinessManager(String email, String password){
		this.email = email;
		this.password = password;
	}

	//Allows business manager to pull reports of sales
	public void pullReports(){
		
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
