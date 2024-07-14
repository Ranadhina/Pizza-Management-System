 package com.pizzamanagement.pizzatype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagement.pizzatype.entity.PizzaType;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Integer> {

	public PizzaType findByPizzaType(String pizzatype);
}
