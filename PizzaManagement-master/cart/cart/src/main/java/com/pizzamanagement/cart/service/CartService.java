package com.pizzamanagement.cart.service;

import java.util.List;

import com.pizzamanagement.cart.entity.Cart;

public interface CartService {

	public Cart addCartItem(Cart cart);

	public String deleteCartItem(Integer cartId);

	public Cart findCartItemById(Integer cartId);

	public Cart updateCartItem(Cart cart);

	public List<Cart> findAllCartItems();
	
	
	public List<Cart> findCartByUserId(Integer id);

}
