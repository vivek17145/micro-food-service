package com.foodie.order.modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId; // The user who placed the order

    @ElementCollection
    private List<String> itemIds; // List of item IDs in the order

    private double totalAmount;

    private String status; // Pending, Completed, Cancelled, etc.

    private LocalDateTime orderDate; // Date & Time of order
}

