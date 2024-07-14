package com.pizzamanagement.cart.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pizzamanagement.cart.entity.Pizza;

@FeignClient(value="pizza", url="http://localhost:8091")
public interface PizzaService {
	
	
	@GetMapping("pizza/{id}")
	public Pizza getPizzaById(@PathVariable(value = "id") int id);
	
	

}
