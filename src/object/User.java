package object;

public class User {

	//Variables
	String userId;
	String loginStatus;
	
	//Default Constructor
	public User(){
		
	}
	
	//Constructor
	public User(String userId, String loginStatus) {
		this.userId = userId;
		this.loginStatus = loginStatus;
	}

	//Register as a User of the site
	public void register(){
		
	}
	
	//Getters & Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	

}
