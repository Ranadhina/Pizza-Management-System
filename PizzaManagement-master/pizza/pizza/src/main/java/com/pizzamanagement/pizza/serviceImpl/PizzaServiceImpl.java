package com.pizzamanagement.pizza.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.pizza.entity.Pizza;
import com.pizzamanagement.pizza.entity.PizzaType;
import com.pizzamanagement.pizza.repository.PizzaRepository;
import com.pizzamanagement.pizza.service.PizzaService;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	public PizzaRepository pizzarepository;

	@Override
	public Pizza addPizza(Pizza pizza) {
		return pizzarepository.save(pizza);
	}

	@Override
	public String deletePizza(Integer pizzaId) {

		if (!pizzarepository.findById(pizzaId).isEmpty()) {
			pizzarepository.deleteById(pizzaId);
			return "Pizza Deleted Successfully";
		} else {
			return "Pizza not Found";
		}
	}

	@Override
	public Pizza findPizzaById(Integer pizzaId) {
		return pizzarepository.findById(pizzaId).get();
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {

		if (pizza.getPizzaId() == null || !pizzarepository.existsById(pizza.getPizzaId())) {
			throw new IllegalArgumentException("Pizza not found");

		}

		Pizza upPizza = pizzarepository.findById(pizza.getPizzaId()).get();
		upPizza.setPizzaName(pizza.getPizzaName());
		upPizza.setPizzaCost(pizza.getPizzaCost());
		upPizza.setPizzaDescription(pizza.getPizzaDescription());
		upPizza.setPizzaSize(pizza.getPizzaSize());
		upPizza.setPizzaType(pizza.getPizzaType());
		return pizzarepository.save(upPizza);
	}

	@Override
	public List<Pizza> findAllPizza() {
		return pizzarepository.findAll();
	}

}
