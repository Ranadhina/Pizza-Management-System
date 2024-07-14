package com.pizzamanagement.toppings.controller;

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

import com.pizzamanagement.toppings.entity.Toppings;
import com.pizzamanagement.toppings.serviceImpl.ToppingsServiceImpl;

@RestController
@RequestMapping("topping")
public class ToppingsController {

	@Autowired
	public ToppingsServiceImpl toppingserviceImpl;

	@PostMapping
	public Toppings saveTopping(@RequestBody Toppings toppings) {
		return toppingserviceImpl.addToppings(toppings);
	}

	@DeleteMapping("/{id}")
	public String removeTopping(@PathVariable Integer id) {
		return toppingserviceImpl.deleteToppings(id);
	}

	@GetMapping("/{id}")
	public Toppings searchTopping(@PathVariable Integer id) {
		return toppingserviceImpl.findToppingsById(id);
	}

	@GetMapping
	public List<Toppings> searchAllToppings() {
		return toppingserviceImpl.findAllToppings();
	}

	@PutMapping
	public Toppings updateToppings(@RequestBody Toppings toppings) {
		return toppingserviceImpl.updateToppings(toppings);
	}

}
