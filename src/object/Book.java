package object;

public class Book extends Item {

	//Variables
	String isbn;
	String author;
	String title;
	//CoverPictureVariable?
	int edition;
	String publisher;
	int publicationYear;
	String description;
	
	//Default Constructor
	public Book() {
		
	}
	
	//Constructor
	public Book(String isbn, String author, String title, int edition, String publisher, int publicationYear, String description) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.description = description;
	}

	//Remove a book from the store
	public void removeBook(){
		
	}
	
	//Getters and Setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	
	

}
