package com.foodie.food.service;

import com.foodie.food.dto.FoodDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FoodService {
    FoodDTO saveFood(FoodDTO FoodDTO);
    FoodDTO getFoodById(String id);
    List<FoodDTO> getAllFoods();
    List<FoodDTO> getFoodsByRestaurantId(String restaurantId);
    FoodDTO updateFood(String id, FoodDTO FoodDTO);
    void deleteFood(String id);
}
