package com.pizzamanagement.pizzaorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagement.pizzaorder.entity.PizzaOrder;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer>{

	
	public List<PizzaOrder> findByUserId(Integer userId);
}
