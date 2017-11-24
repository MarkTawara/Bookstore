package object;

public class Item {

	//Variables
	int itemID;
	double price;
	String name;
	
	//Default constructor
	public Item() {
		
	}

	//Constructor
	public Item(int itemID, double price, String name) {
		this.itemID = itemID;
		this.price = price;
		this.name = name;
	}
	
	//Adds an item to a cart
	public void addToCart() {
		
	}
	
	//Getters and Setters
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
