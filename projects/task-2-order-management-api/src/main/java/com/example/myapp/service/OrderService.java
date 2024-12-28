package com.example.myapp.service;

import com.example.myapp.model.Order;
import com.example.myapp.dto.OrderRequest;
import com.example.myapp.repository.OrderRepository;
import com.example.myapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private OrderRepository orderRepository;

    private WebClient.Builder webClientBuilder;


    OrderService(OrderRepository orderRepository) {
	this.orderRepository = orderRepository;
	this.webClientBuilder = WebClient.builder();
    }

    public Order findOrderById(Long id) {
	return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
	return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
	return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
	return orderRepository.findByUserId(userId);
    }

    public Order createOrder(OrderRequest orderRequest) {
	Order order = new Order();
	order.setUserId(orderRequest.getUserId());
	order.setProductName(orderRequest.getProductName());
	order.setQuantity(orderRequest.getQuantity());

	// Get user with userId from user microservice with Webclient
	User user = webClientBuilder.build()
	    .get()
	    .uri("http://localhost:8080/users/" + order.getUserId())
	    .retrieve()
	    .bodyToMono(User.class)
	    .block();

	// Set user to order
	order.setEmail(user.getEmail());
	order.setUserName(user.getName());
	return orderRepository.save(order);
    }
}
