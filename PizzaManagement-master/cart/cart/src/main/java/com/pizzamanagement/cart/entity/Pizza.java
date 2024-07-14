package com.pizzamanagement.cart.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

	private Integer pizzaId;
	private String pizzaName;
	private String pizzaDescription;
	private Double pizzaCost;
	@Enumerated(EnumType.STRING)
	private PizzaSize pizzaSize;

	@Enumerated(EnumType.STRING)
	private PizzaType pizzaType;

}
