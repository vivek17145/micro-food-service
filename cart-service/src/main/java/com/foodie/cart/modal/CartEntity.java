package com.foodie.cart.modal;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    private String id;
    private String userId;
    private int quantity;
    @ElementCollection
    private List<String> itemIds;
    private double totalPrice;
}
