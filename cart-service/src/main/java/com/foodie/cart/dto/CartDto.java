package com.foodie.cart.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private String id;
    private String userId;
    private int quantity;
    private List<String> itemIds;
    private double totalPrice;
}
