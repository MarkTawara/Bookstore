package object;

import java.util.Date;

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
	Date dateOrderedReal;
	String shippingAddress;
	String titleList;
	
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
	
	public Order(){
		
	}
	
	public Order(int orderId, Date date, double price, String status){
		this.orderId = orderId;
		this.dateOrderedReal = date;
		this.totalPrice = price;
		this.status = status;
	}
	
	
	
	//Getters & Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getTitleList(){
		return titleList;
	}
	
	public void setTitleList(String t){
		this.titleList = t;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String s){
		status = s;
	}
	
	public Date getDateOrderedReal(){
		return dateOrderedReal;
	}
	
	public void setDateOrderedReal(Date date){
		this.dateOrderedReal = date;
	}
	
	public String getShippingAddress(){
		return shippingAddress;
	}
	
	public void setShippingAddress(String address){
		this.shippingAddress = address;
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
