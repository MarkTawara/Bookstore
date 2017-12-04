package object;

import java.sql.Blob;

public class Book extends Item {

	//Variables
	String isbn;
	String author;
	String title;
	double price;
	Blob cover_picture;
	int edition;
	String publisher;
	int publicationYear;
	String description;
	int quantityInCart;
	String subject;
	int quantityInStock;
	String pic;
	
	//Default Constructor
	public Book() {
		
	}
	
	//Constructor
	public Book(String isbn, String author, double price, String title, int edition, String publisher, int publicationYear, String description, int quantityInCart) {
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.title = title;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
		this.quantityInCart = quantityInCart;
	}
	
	public Book(String isbn, String author, double price, String title, Blob cover_picture, int edition, String publisher, int publicationYear, String description, int quantityInCart, String subject) {
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.title = title;
		this.cover_picture = cover_picture;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
		this.quantityInCart = quantityInCart;
		this.subject = subject;
	}
	
	public Book(String isbn, String author, double price, String title, String cover_picture, int edition, String publisher, int publicationYear, String description, int quantityInCart, String subject) {
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.title = title;
		this.pic = cover_picture;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
		this.quantityInCart = quantityInCart;
	}
	
	public Book(String isbn, String author, double price, String title, String cover_picture, int edition, String publisher, int publicationYear, String description, int quantityInCart) {
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.title = title;
		this.pic = cover_picture;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
		this.quantityInCart = quantityInCart;
	}

	//Getters and Setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getQuantityInStock(){
		return quantityInStock;
	}
	
	public void setQuantityInStock(int q){
		this.quantityInStock = q;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantityInCart(){
		return quantityInCart;
	}
	
	public void setQuantityInCart(int quantityInCart){
		this.quantityInCart = quantityInCart;
	}

	public Blob getCover_picture() {
		return cover_picture;
	}

	public void setCover_picture(Blob cover_picture) {
		this.cover_picture = cover_picture;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
}
