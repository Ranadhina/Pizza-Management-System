package com.pizzamanagement.pizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaId;
	private String pizzaName;
	private String pizzaDescription;
	private Double pizzaCost;
	@Enumerated(EnumType.STRING)
	private PizzaSize pizzaSize;

	@Enumerated(EnumType.STRING)
	private PizzaType pizzaType;

}
