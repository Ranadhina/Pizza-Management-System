package com.pizzamanagement.pizzatype.controller;

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

import com.pizzamanagement.pizzatype.entity.PizzaType;
import com.pizzamanagement.pizzatype.serviceimpl.PizzaTypeServiceImpl;

@RestController
@RequestMapping("/pizzatype")
public class PizzaTypeController {
	@Autowired
	PizzaTypeServiceImpl pizzaserviceimpl;

	@PostMapping
	public PizzaType savePizzaType(@RequestBody PizzaType pizzatype)
	{
		return pizzaserviceimpl.addPizzaType(pizzatype);
	}
	
	@DeleteMapping("/{id}")
	public String removePizzaTypeById(@PathVariable Integer id)
	{
		return pizzaserviceimpl.deletePizzaType(id);
	}
	
	@GetMapping("/{id}")
	public PizzaType getPizzaTypeById(@PathVariable Integer id)
	{
		return pizzaserviceimpl.findPizzaTypeById(id);
	}
	
	
	@GetMapping("/type/{type}")
	public PizzaType getPizzaTypeById(@PathVariable String type)
	{
		return pizzaserviceimpl.findPizzaByType(type);
	}
	
	@GetMapping
	public List<PizzaType> searchAll()
	{
		return pizzaserviceimpl.findAll();
	}
	
	@PutMapping
	public PizzaType updateType(PizzaType pizzatype)
	{
		return pizzaserviceimpl.updatePizzaType(pizzatype);
	}
}
