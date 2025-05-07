package com.foodie.cart.service.impl.repository;

import com.foodie.cart.modal.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, String> {
}
