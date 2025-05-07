package com.foodie.food.repository;

import com.foodie.food.modal.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, String> {
    Optional<FoodEntity> findByRestaurantId(String restaurantId);
}
