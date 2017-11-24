package object;

public class Order {

	//Variables used in class
	int orderId;
	String dateOrdered;
	String customerName;
	String customerId;
	String status;
	int shippingId;
	double totalPrice;
	String paymentMethod;
	String billingAddress;
	int cartId;
	
	//Constructor
	public Order(int orderId, String dateOrdered, String customerName, String customerId, String status, int shippingId, double totalPrice, String paymentMethod, String billingAddress, int cartId) {
		this.orderId = orderId;
		this.dateOrdered = dateOrdered;
		this.customerName = customerName;
		this.customerId = customerId;
		this.status = status;
		this.shippingId = shippingId;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.billingAddress = billingAddress;
		this.cartId = cartId;
	}
	
	//Send confirmation that an order has been placed.
	public void sendConfirmation(){
		
	}
	
	//Updates the order to either on its way, delivered, or lost(?)
	public void updateOrderStatus() {
		
	}
	
	//Getters & Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	

}
