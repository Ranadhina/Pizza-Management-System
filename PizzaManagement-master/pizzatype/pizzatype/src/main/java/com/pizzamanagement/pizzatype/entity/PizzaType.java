package com.pizzamanagement.pizzatype.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
public class PizzaType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaTypeId;
	private String pizzaType;
	private List<Integer> toppingsIds = new ArrayList<>();

}
