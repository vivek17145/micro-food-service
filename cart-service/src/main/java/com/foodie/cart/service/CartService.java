package com.foodie.cart.service;

import com.foodie.cart.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    List<CartDto> getAllCarts();

    CartDto getCartById(String id);

    CartDto saveCart(CartDto cartDto);

    void deleteCart(String id);
}
