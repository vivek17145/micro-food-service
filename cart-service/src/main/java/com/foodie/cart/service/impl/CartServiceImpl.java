package com.foodie.cart.service.impl;

import com.foodie.cart.dto.CartDto;
import com.foodie.cart.modal.CartEntity;
import com.foodie.cart.service.CartService;
import com.foodie.cart.service.impl.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    // Get all carts
    public List<CartDto
            > getAllCarts() {
        List<CartEntity> carts = cartRepository.findAll();
        List<CartDto> cartDtos = new ArrayList<>();
        for (CartEntity cart : carts) {
            cartDtos.add(mapToDto(cart));
        }
        return cartDtos;
    }

    // Get a single cart by ID
    public CartDto getCartById(String id) {
        CartEntity cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + id));
        return mapToDto(cart);
    }

    // Create or update a cart
    public CartDto saveCart(CartDto cartDto) {
        CartEntity cart = mapToEntity(cartDto);
        CartEntity savedCart = cartRepository.save(cart);
        return mapToDto(savedCart);
    }

    // Delete a cart by ID
    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

    // Mapping from Entity to DTO
    private CartDto mapToDto(CartEntity cart) {
        return new CartDto(cart.getId(), cart.getUserId(), cart.getQuantity(), cart.getItemIds(), cart.getTotalPrice());
    }

    // Mapping from DTO to Entity
    private CartEntity mapToEntity(CartDto cartDto) {
        return new CartEntity(cartDto.getId(), cartDto.getUserId(), cartDto.getQuantity(), cartDto.getItemIds(), cartDto.getTotalPrice());
    }
}
