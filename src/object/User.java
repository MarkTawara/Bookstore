package object;

public class User {

	//Variables
	String userId;
	String loginStatus;
	String userStatus;
	String accountStatus;

	//Default Constructor
	public User(){

	}

	//Constructor
	public User(String userId, String loginStatus) {
		this.userId = userId;
		this.loginStatus = loginStatus;
	}

	//Constructor
	public User(String userId, String userStatus, String accountStatus) {
		this.userId = userId;
		this.userStatus = userStatus;
		this.accountStatus = accountStatus;
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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
