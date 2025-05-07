package com.foodie.order.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id;
    private String userId;
    private List<String> itemIds;
    private double totalAmount;
    private String status;
    private LocalDateTime orderDate;
}