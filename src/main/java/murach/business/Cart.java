package murach.business;

import java.util.ArrayList;
import java.util.List;

import murach.business.*;

public class Cart {
	private List<CartItem> cartItems;
	
	public Cart() {
		this.cartItems = new ArrayList<CartItem>();
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	
	public void addCartItem(CD cd) {
		boolean is_existed = false;
		for(CartItem cartItem : this.cartItems) {
			if(cartItem.getCd().getCode() == cd.getCode()) {
				is_existed = true;
				cartItem.setQuantity(cartItem.getQuantity() + 1);
			}
		}
		if (!is_existed) {
			CartItem cartItem = new CartItem(cd, 1);
			this.cartItems.add(cartItem);
		}
	}
	
	public void updateQuantity(CD cd, int quantity) {
		int index = 0;
		for(CartItem cartItem : this.cartItems) {
			if(cartItem.getCd().getCode() == cd.getCode()) {
				if(quantity > 0) {
					cartItem.setQuantity(quantity);
				}
				if(quantity == 0) {
					this.cartItems.remove(index);
					break;
				}
			}
			index += 1;
		}
	}
	
	public void remove(int code) {
		int index = 0;
		for(CartItem cartItem : this.cartItems) {
			if(cartItem.getCd().getCode() == code) {;
				this.cartItems.remove(index);
				break;
			}
			index += 1;
		}
	}
	
}