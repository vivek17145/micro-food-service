package com.foodie.food.controller;

import java.util.List;

import com.foodie.food.dto.FoodDTO;
import com.foodie.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {
    
    @Autowired
    private FoodService foodService;

    @PostMapping("/create")
    public FoodDTO createFood(@RequestBody FoodDTO foodDTO) {
        return foodService.saveFood(foodDTO);
    }

    @GetMapping("/{id}")
    public FoodDTO getFoodById(@PathVariable String id) {
        return foodService.getFoodById(id);
    }

    @GetMapping("/all")
    public List<FoodDTO> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodDTO> getFoodsByRestaurantId(@PathVariable String restaurantId) {
        return foodService.getFoodsByRestaurantId(restaurantId);
    }

    @PutMapping("/{id}")
    public FoodDTO updateFood(@PathVariable String id, @RequestBody FoodDTO foodDTO) {
        return foodService.updateFood(id, foodDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable String id) {
        foodService.deleteFood(id);
    }
}