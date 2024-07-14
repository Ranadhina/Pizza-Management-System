package com.pizzamanagement.pizzaorder.service;

import java.util.List;

import com.pizzamanagement.pizzaorder.entity.PizzaOrder;

public interface PizzaOrderService {

	public PizzaOrder addPizzaOrder(PizzaOrder pizzaorder);

	public String deletePizzaOrder(Integer pizzaorderId);

	public PizzaOrder findPizzaOrderById(Integer pizzaorderId);

	public PizzaOrder updatePizzaOrder(PizzaOrder pizzaorder);

	public List<PizzaOrder> findAllPizzaOrder();
	
	public List<PizzaOrder> findPizzaOrderByUserId(Integer id);
}
