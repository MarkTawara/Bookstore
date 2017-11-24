package object;

public class Promotion {

	//Variables
	String code;
	String expirationDate;
	int percentOff;
	
	//Constructor
	public Promotion(String code, String expirationDate, int percentOff) {
		this.code = code;
		this.expirationDate = expirationDate;
		this.percentOff = percentOff;
	}
	
	//Set the status of the promotion. Is it discontinued? 
	public void updatePromotion() {
		
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
