package com.pizzamanagement.pizza.service;

import java.util.List;

import com.pizzamanagement.pizza.entity.Pizza;

public interface PizzaService {

	public Pizza addPizza(Pizza pizza);

	public String deletePizza(Integer pizzaId);

	public Pizza findPizzaById(Integer pizzaId);

	public Pizza updatePizza(Pizza pizza);
		
	public List<Pizza> findAllPizza();

}
