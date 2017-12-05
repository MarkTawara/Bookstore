package object;

import java.util.Date;

public class Promotion {

	//Variables
	String code;
	String expirationDate;
	Date expirationDateReal;
	int percentOff;
	
	//Default Constructor
	public Promotion() {
		
	}	
	
	//Constructor
	public Promotion(String code, String expirationDate, int percentOff) {
		this.code = code;
		this.expirationDate = expirationDate;
		this.percentOff = percentOff;
	}
	
	public Date getDate(){
		return expirationDateReal;
	}

	public void setDate(Date d){
		this.expirationDateReal = d;		
	}
	
	//Getters & Setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getPercentOff() {
		return percentOff;
	}

	public void setPercentOff(int percentOff) {
		this.percentOff = percentOff;
	}

	
}
