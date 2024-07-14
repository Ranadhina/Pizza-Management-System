package com.pizzamanagement.toppings.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.toppings.entity.Toppings;
import com.pizzamanagement.toppings.repository.ToppingsRepository;
import com.pizzamanagement.toppings.service.ToppingsService;

@Service
public class ToppingsServiceImpl implements ToppingsService {

	@Autowired
	public ToppingsRepository toppingsrepository;

	@Override
	public Toppings addToppings(Toppings toppings) {
		return toppingsrepository.save(toppings);
	}

	@Override
	public String deleteToppings(Integer toppingsId) {

		if (!toppingsrepository.findById(toppingsId).isEmpty()) {

			toppingsrepository.deleteById(toppingsId);
			return "Topping Deleted Successfully";
		} else {
			return "Topping Not Found";
		}
	}

	@Override
	public Toppings findToppingsById(Integer toppingsId) {
		return toppingsrepository.findById(toppingsId).get();
	}

	@Override
	public Toppings updateToppings(Toppings toppings) {

		if (toppings.getToppingsId() == null || !toppingsrepository.existsById(toppings.getToppingsId())) {
			throw new IllegalArgumentException("Toppings not found");
		}

		Toppings top = toppingsrepository.findById(toppings.getToppingsId()).get();

		top.setToppingName(toppings.getToppingName());
		top.setPrice(toppings.getPrice());
		return toppingsrepository.save(top);
	}

	@Override
	public List<Toppings> findAllToppings() {
		return toppingsrepository.findAll();
	}

}
