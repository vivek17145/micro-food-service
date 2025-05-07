package com.foodie.restaurant.controller;

import com.foodie.restaurant.dto.RestaurantDto;
import com.foodie.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    // Create or update restaurant
    @PostMapping("save")
    public RestaurantDto createOrUpdateRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.saveOrUpdate(restaurantDto);
    }

    // Get all restaurants
    @GetMapping("/all")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get restaurant by ID
    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }

    // Delete a restaurant by ID
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
    }
}

