package com.pizzamanagement.pizza.controller;

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

import com.pizzamanagement.pizza.entity.Pizza;
import com.pizzamanagement.pizza.serviceImpl.PizzaServiceImpl;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaServiceImpl pizzaserviceImpl;
	
	
	@PostMapping
	public Pizza savePizza(@RequestBody Pizza pizza)
	{
		return pizzaserviceImpl.addPizza(pizza);
	}
	
	@DeleteMapping("/{id}")
	public String removePizza(@PathVariable Integer id)
	{
		return pizzaserviceImpl.deletePizza(id);
	}
	
	
	@GetMapping("/{id}")
	public Pizza searchPizzaById(@PathVariable Integer id)
	{
		return pizzaserviceImpl.findPizzaById(id);
	}
	
	@GetMapping
	public List<Pizza> searchAll()
	{
		return pizzaserviceImpl.findAllPizza();
	}
	
	@PutMapping
	public Pizza updatePizza(@RequestBody Pizza pizza)
	{
		return pizzaserviceImpl.updatePizza(pizza);
	}

}
