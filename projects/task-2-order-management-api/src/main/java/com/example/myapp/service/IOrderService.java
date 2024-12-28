package com.example.myapp.service;

import com.example.myapp.model.Order;

import com.example.myapp.dto.OrderRequest;
import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getAllOrders();
    Order saveOrder(Order order);

    Order createOrder(OrderRequest orderRequest);
    List<Order> getOrdersByUserId(Long userId);
    Order findOrderById(Long id);
}
