package com.pizzamanagement.pizzaorder.controller;

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

import com.pizzamanagement.pizzaorder.entity.PizzaOrder;
import com.pizzamanagement.pizzaorder.serviceimpl.PizzaOrderServiceImpl;

@RestController
@RequestMapping("/pizzaorder")
public class PizzaOrderController {

	@Autowired
	public PizzaOrderServiceImpl pizzaorderserviceimpl;

	@PostMapping
	public PizzaOrder savePizzaOrder(@RequestBody PizzaOrder pizzaorder) {
		return pizzaorderserviceimpl.addPizzaOrder(pizzaorder);

	}

	@DeleteMapping("/{id}")
	public String removePizzaOrder(@PathVariable Integer id) {
		return pizzaorderserviceimpl.deletePizzaOrder(id);
	}

	@GetMapping("/{id}")
	public PizzaOrder getPizzaOrder(@PathVariable Integer id) {
		return pizzaorderserviceimpl.findPizzaOrderById(id);
	}

	@GetMapping
	public List<PizzaOrder> getAllPizzaOrder() {
		return pizzaorderserviceimpl.findAllPizzaOrder();
	}
	
	@GetMapping("/user/{id}")
	public List<PizzaOrder> getPizzaOrderByUserId(@PathVariable Integer id) {
		return pizzaorderserviceimpl.findPizzaOrderByUserId(id);
	}
	
	
	@PutMapping()
	public PizzaOrder UpdateOrder(@RequestBody PizzaOrder pizzaorder)
	{
		return pizzaorderserviceimpl.updatePizzaOrder(pizzaorder);
	}
	
	

}
