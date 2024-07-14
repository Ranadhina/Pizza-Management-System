package com.pizzamanagement.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagement.cart.entity.Cart;
import com.pizzamanagement.cart.serviceimpl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
    public CartServiceImpl cartserviceImpl;	
	
	
	@PostMapping
	public Cart saveCartItem(@RequestBody Cart cart)
	{
		return cartserviceImpl.addCartItem(cart);
	}
	
	@DeleteMapping("/{id}")
	public String removeCartItem(@PathVariable Integer id)
	{
		return cartserviceImpl.deleteCartItem(id);
	}
	
	
	@GetMapping("/{id}")
	public Cart searchByCartId(@PathVariable Integer id)
	{
		return cartserviceImpl.findCartItemById(id);
		
	}
	
	@GetMapping
	public List<Cart> searchAllCartItems()
	{
		return cartserviceImpl.findAllCartItems();
	}
	
	@GetMapping("/user/{id}")
	public List<Cart> searchCartByUserId(@PathVariable Integer id)
	{
		return cartserviceImpl.findCartByUserId(id);
	}
	
	@PutMapping
	public Cart updateCart(@RequestBody Cart cart)
	{
		return cartserviceImpl.updateCartItem(cart);
	}
}
