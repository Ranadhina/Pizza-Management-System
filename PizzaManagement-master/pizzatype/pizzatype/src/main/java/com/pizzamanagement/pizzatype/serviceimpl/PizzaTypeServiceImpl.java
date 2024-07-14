package com.pizzamanagement.pizzatype.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.pizzatype.entity.PizzaType;
import com.pizzamanagement.pizzatype.repository.PizzaTypeRepository;
import com.pizzamanagement.pizzatype.service.PizzaTypeService;

@Service
public class PizzaTypeServiceImpl implements PizzaTypeService{
	
	
	@Autowired
	PizzaTypeRepository pizzatyperepository;

	@Override
	public PizzaType addPizzaType(PizzaType pizzatype) {
		
		return pizzatyperepository.save(pizzatype);
	}

	@Override
	public String deletePizzaType(Integer pizzaTypeId) {
				if(!pizzatyperepository.findById(pizzaTypeId).isEmpty())
				{
					pizzatyperepository.deleteById(pizzaTypeId);
					return "PizzaType Deleted Successfully";
				}
				else
				{
					return "PizzaType Not Found";
				}
	}

	@Override
	public PizzaType findPizzaTypeById(Integer pizzaTypeId) {
		
		return pizzatyperepository.findById(pizzaTypeId).get();
	}

	@Override
	public PizzaType updatePizzaType(PizzaType pizzatype) {

		if(pizzatype.getPizzaTypeId() == null|| !pizzatyperepository.existsById(pizzatype.getPizzaTypeId()))
		{
	        throw new IllegalArgumentException("Type not found");

		}
		PizzaType type=pizzatyperepository.findById(pizzatype.getPizzaTypeId()).get();
		
		type.setPizzaType(pizzatype.getPizzaType());
		type.setToppingsIds(pizzatype.getToppingsIds());
		
		return pizzatyperepository.save(type);
	}

	@Override
	public PizzaType findPizzaByType(String pizzaType) {
		return pizzatyperepository.findByPizzaType(pizzaType);
	}

	@Override
	public List<PizzaType> findAll() {
		return pizzatyperepository.findAll();
	}

}
