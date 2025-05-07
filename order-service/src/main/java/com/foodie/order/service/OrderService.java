package com.foodie.order.service;

import com.foodie.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();

    OrderDto getOrderById(String id);

    OrderDto createOrder(OrderDto orderDto);

    void deleteOrder(String id);
}

