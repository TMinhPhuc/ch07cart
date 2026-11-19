package murach.business;

public class CD {
	private int code;
	private String description;
	private double price;
	
	public CD(int code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
