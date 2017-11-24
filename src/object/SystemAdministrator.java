package object;

public class SystemAdministrator extends User{

	//Variables
	String adminName;
	String email;
	String password;
	
	//Default constructor
	public SystemAdministrator() {
		super();
	}
	
	//Constructor
	public SystemAdministrator(String adminName, String email, String password){
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}

	//Let sysAdm remove an employee 
	public void removeEmployee(){
		
	}
	
	//Let sysAdm add an employee
	public void addEmployee(){
		
	}
	
	//Let sysAdm add a promotion
	public void addPromotion(){
		
	}
	
	//Let sysAdm remove a promotions
	public void removePromotion(){
		
	}
	
	//Let sysAdm add a shipping agency
	public void addShippingAgency(){
		
	}
	
	//Let sysAdm add supplier information
	public void addSupplierInformation(){
		
	}
	
	//Let sysAdm remove a book from the store
	public void deleteBook(){
		
	}
	
	//Let sysAdm update info about a book in the store
	public void updateBook(){
		
	}
	
	//Let sysAdm add a book to the store
	public void addBook(){
		
	}
	
	//Let sysAdm authorize an employee (?)
	public void authorizeEmployee(){
		
	}
	
	//Let sysAdm delete a registered customer's account
	public void deleteMemberAccount(){
		
	}
	
	//Let sysAdm update a registered customer's account
	public void updateMemberAccount(){
		
	}
	
	//Let sysAdm suspend a registered customer's account.
	public void suspendMemberAccount(){
		
	}
	
	//Let sysAdm pull reports about sales
	public void pullReports(){
		
	}
	
	//Getters & Setters
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
