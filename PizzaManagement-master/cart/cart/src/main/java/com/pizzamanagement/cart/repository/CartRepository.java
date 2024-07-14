package com.pizzamanagement.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagement.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	public List<Cart> findByUserId(Integer id);
}
