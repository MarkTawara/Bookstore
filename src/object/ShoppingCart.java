package object;

public class ShoppingCart {
	
	//Variables
	int cartID;
	int quantity;
	
	//Default Constructor
	public ShoppingCart() {
		
	}
	
	//Constructor
	public ShoppingCart(int cartID, int quantity) {
		this.cartID = cartID;
		this.quantity = quantity;
	}

	//Begin to order the items that are in the cart
	public void checkOut() {
		
	}
	
	//Remove a book from the cart
	public void removeFromCart() {
		
	}
	
	//Apply the promotion code
	public void usePromotion() {
		
	}
	
	//Getters and Setters
	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
