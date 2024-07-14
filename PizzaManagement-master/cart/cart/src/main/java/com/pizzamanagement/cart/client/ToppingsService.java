package com.pizzamanagement.cart.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pizzamanagement.cart.entity.Toppings;

@FeignClient(value = "toppings", url = "http://localhost:8094")
public interface ToppingsService {
  
	
	@GetMapping("topping/{id}")
	public Toppings getToppingsById(@PathVariable(value = "id") int id);
}
