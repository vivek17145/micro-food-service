package com.foodie.food.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foodie.food.enums.FoodType;
import com.foodie.food.modal.FoodCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String id;
    private String title;
    private String description;
    private Integer quantity;
    private Boolean outOfStock;
    private FoodType foodType;
    private String categoryId;
    @JsonIgnore
    private FoodCategory foodCategory;
    private String restaurantId;
    private RestaurantDto restaurant;
}
