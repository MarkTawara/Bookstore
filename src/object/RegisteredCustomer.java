package object;

public class RegisteredCustomer extends User{

	String customerName;
	String billingAddress;
	String email;
	String shippingAddress;
	int customerId;
	String phoneNumber;
	String paymentInfo;
	String password;
	int cartId;
	
	//Default Constructor
	public RegisteredCustomer() {
		super();
	}
	
	//Constructor
	public RegisteredCustomer(String customerName, String billingAddress, String email, String shippingAddress, int customerId, String phoneNumber, String paymentInfo, String password, int cartId){
		this.customerName = customerName;
		this.billingAddress = billingAddress;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.paymentInfo = paymentInfo;
		this.password = password;
		this.cartId = cartId;
	}

	//Let the user Login
	public void Login(){
		
	}
	
	//Let the registered customer changePassword
	public void changePassword(){
		
	}
	
	//Let the registered customer updateProfile
	public void updateProfile(){
		
	}
	
	//Let the registered customer unsubscribe from promotions
	public void unsubscribePromotions(){
		
	}
	
	//Let the registered customer subscribe to promotions
	public void subscribePromotions(){
		
	}
	
	//Let the registered customer place an order
	public void placeOrder(){
		
	}
	
	//Let the registered customer view their cart
	public void viewCart(){
		
	}
	
	//Getters & Setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	

}
