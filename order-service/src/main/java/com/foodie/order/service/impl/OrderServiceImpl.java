package com.foodie.order.service.impl;

import com.foodie.order.dto.OrderDto;
import com.foodie.order.modal.OrderEntity;
import com.foodie.order.repository.OrderRepository;
import com.foodie.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    // Get all orders
    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Get order by ID
    @Override
    public OrderDto getOrderById(String id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
        return mapToDto(order);
    }

    // Create a new order
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity order = mapToEntity(orderDto);
        order.setOrderDate(LocalDateTime.now());
        OrderEntity savedOrder = orderRepository.save(order);
        return mapToDto(savedOrder);
    }

    // Delete an order
    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private OrderDto mapToDto(OrderEntity order) {
        return new OrderDto(
                order.getId(),
                order.getUserId(),
                order.getItemIds(),
                order.getTotalAmount(),
                order.getStatus(),
                order.getOrderDate()
        );
    }

    // Convert DTO to Entity
    private OrderEntity mapToEntity(OrderDto orderDto) {
        return new OrderEntity(
                orderDto.getId(),
                orderDto.getUserId(),
                orderDto.getItemIds(),
                orderDto.getTotalAmount(),
                orderDto.getStatus(),
                orderDto.getOrderDate()
        );
    }
}

