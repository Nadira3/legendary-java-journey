package com.example.myapp.controller;

import com.example.myapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.myapp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import com.example.myapp.dto.OrderRequest;

import org.springframework.http.ResponseEntity;

import java.util.List;

// OrderController.java
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private WebClient.Builder webClientBuilder;

    // Inject OrderService and WebClient.Builder
    // Constructor
public OrderController(OrderService orderService, WebClient.Builder webClientBuilder) {
	this.orderService = orderService;
	this.webClientBuilder = webClientBuilder;
}

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
	    	// Create a new order
	Order order = orderService.createOrder(orderRequest);
	return ResponseEntity.ok(order);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        // Retrieve orders for the given user ID
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
