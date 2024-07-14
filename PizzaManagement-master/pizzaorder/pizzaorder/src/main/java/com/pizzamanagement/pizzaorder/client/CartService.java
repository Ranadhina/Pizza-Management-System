package com.pizzamanagement.pizzaorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pizzamanagement.pizzaorder.entity.Cart;

@FeignClient(value = "cart",url = "http://localhost:8096")
public interface CartService {
	
//	@GetMapping("cart/user/{id}")
//	public List<Cart> getCartByUserId(@PathVariable(value = "id") int id);
	
	@GetMapping("cart/{id}")
	public Cart searchByCartId(@PathVariable(value="id") int id);
}
