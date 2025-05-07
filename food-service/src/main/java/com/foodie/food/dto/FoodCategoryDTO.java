package com.foodie.food.dto;

import com.foodie.food.modal.FoodEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategoryDTO {
    private String id;
    private String name;
    private String description;
    private List<FoodDTO> foodItems = new ArrayList<>();
}
