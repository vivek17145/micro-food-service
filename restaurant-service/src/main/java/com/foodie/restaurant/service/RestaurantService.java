package com.foodie.restaurant.service;

import com.foodie.restaurant.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurants();

    RestaurantDto getRestaurantById(String id);

    RestaurantDto saveOrUpdate(RestaurantDto restaurantDto);

    void deleteRestaurant(String id);
}
