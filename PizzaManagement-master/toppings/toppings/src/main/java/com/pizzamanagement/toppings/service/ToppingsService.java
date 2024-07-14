package com.pizzamanagement.toppings.service;

import java.util.List;

import com.pizzamanagement.toppings.entity.Toppings;

public interface ToppingsService {
	
	
	public Toppings addToppings(Toppings toppings);

	public String deleteToppings(Integer toppingsId);

	public Toppings findToppingsById(Integer toppingsId);

	public Toppings updateToppings(Toppings toppings);
		
	public List<Toppings> findAllToppings();

}
