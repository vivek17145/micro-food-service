package com.foodie.cart.controller;

import com.foodie.cart.dto.CartDto;
import com.foodie.cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get all carts
    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    // Get cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable String id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    // Create/Update cart
    @PostMapping
    public ResponseEntity<CartDto> saveCart(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok(cartService.saveCart(cartDto));
    }

    // Delete cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}

