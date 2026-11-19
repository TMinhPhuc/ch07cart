package murach.business;

import murach.business.*;

public class CartItem {
	private CD cd;
	private int quantity;
	private double amount;
	
	public CartItem(CD cd, int quantity) {
		this.cd = cd;
		this.quantity = quantity;
		this.setAmount();
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public void setAmount() {
		this.amount = this.cd.getPrice() * this.quantity;
	}
	
	public CD getCd() {
		return this.cd;
	}
	
	public void setCd(CD cd) {
		this.cd = cd;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.setAmount();
	}
	
}