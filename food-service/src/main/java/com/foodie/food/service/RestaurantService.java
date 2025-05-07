package com.foodie.food.service;

import com.foodie.food.dto.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "http://localhost:8091/api/v1/restaurants")
public interface RestaurantService {
    @GetMapping("/{restaurantId}")
    RestaurantDto getRestaurantById(@PathVariable String restaurantId);
}
