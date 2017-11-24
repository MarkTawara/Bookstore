package object;

public class SupplierInformation {

	//Variables
	String name;
	String address;
	String contactName;
	String email;
	String contactPhoneNumber;
	String businessPhoneNumber;
	
	//Constructor
	public SupplierInformation(String name, String address, String contactName, String email, String contactPhoneNumber, String businessPhoneNumber) {
		this.name = name;
		this.address = address;
		this.contactName = contactName;
		this.email = email;
		this.contactPhoneNumber = contactPhoneNumber;
		this.businessPhoneNumber = businessPhoneNumber;
	}

	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}

	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}
	
	

}
