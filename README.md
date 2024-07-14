This repository contains a set of microservices for managing a pizza ordering system. The services are built using Spring Boot and include functionalities for managing carts, pizza orders, and toppings.


### Microservices

#### Cart Service

This service manages the cart items.

- **client/**: Contains Feign clients for inter-service communication.
  - `CartService.java`: Interface for Cart Service communication.
- **controller/**: Contains REST controllers.
  - `CartController.java`: Controller for managing cart-related endpoints.
- **entity/**: Contains entity classes.
  - `Cart.java`: Entity representing a cart.
- **repository/**: Contains repository interfaces.
  - `CartRepository.java`: JPA repository for `Cart` entity.
- **service/**: Contains service interfaces.
  - `CartService.java`: Interface for Cart Service operations.
- **serviceimpl/**: Contains service implementation classes.
  - `CartServiceImpl.java`: Implementation of `CartService`.

#### Pizza Order Service

This service manages pizza orders.

- **client/**: Contains Feign clients for inter-service communication.
  - `CartService.java`: Interface for Cart Service communication.
- **controller/**: Contains REST controllers.
  - `PizzaOrderController.java`: Controller for managing pizza order-related endpoints.
- **entity/**: Contains entity classes.
  - `Cart.java`: Entity representing a cart (used for internal processing).
  - `PizzaOrder.java`: Entity representing a pizza order.
  - `PizzaStatus.java`: Enum representing the status of a pizza order.
- **repository/**: Contains repository interfaces.
  - `PizzaOrderRepository.java`: JPA repository for `PizzaOrder` entity.
- **service/**: Contains service interfaces.
  - `PizzaOrderService.java`: Interface for Pizza Order Service operations.
- **serviceimpl/**: Contains service implementation classes.
  - `PizzaOrderServiceImpl.java`: Implementation of `PizzaOrderService`.

#### Toppings Service

This service manages pizza toppings.

- **controller/**: Contains REST controllers.
  - `ToppingsController.java`: Controller for managing toppings-related endpoints.
- **entity/**: Contains entity classes.
  - `Toppings.java`: Entity representing a topping.
- **repository/**: Contains repository interfaces.
  - `ToppingsRepository.java`: JPA repository for `Toppings` entity.
- **service/**: Contains service interfaces.
  - `ToppingsService.java`: Interface for Toppings Service operations.
- **serviceimpl/**: Contains service implementation classes.
  - `ToppingsServiceImpl.java`: Implementation of `ToppingsService`.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher
- PostgreSQL
- Eureka Server (for service discovery)


