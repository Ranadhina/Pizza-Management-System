package com.pizzamanagement.pizzaorder.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PizzaOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;

	@CreationTimestamp
	private LocalDateTime dateTimeOfOrder;

	@PrePersist
	private void onCreate() {
		this.dateTimeOfOrder = LocalDateTime.now();
	}

	private List<Integer> cartId = new ArrayList<>(); 
	private Double totalCost;
	private Integer userId;
	@Enumerated(EnumType.STRING)
	private PizzaStatus pizzaStatus;

}
