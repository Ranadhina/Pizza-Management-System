package com.pizzamanagement.pizzatype.service;

import java.util.List;

import com.pizzamanagement.pizzatype.entity.PizzaType;

public interface PizzaTypeService {

	public PizzaType addPizzaType(PizzaType pizzatype);

	public String deletePizzaType(Integer pizzaTypeId);

	public PizzaType findPizzaTypeById(Integer pizzaTypeId);

	public PizzaType updatePizzaType(PizzaType pizzatype);
	
	public PizzaType findPizzaByType(String pizzaType);
	
	public List<PizzaType> findAll();


}
