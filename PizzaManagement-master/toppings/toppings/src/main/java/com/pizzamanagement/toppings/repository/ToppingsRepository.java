package com.pizzamanagement.toppings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzamanagement.toppings.entity.Toppings;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer>{

}
