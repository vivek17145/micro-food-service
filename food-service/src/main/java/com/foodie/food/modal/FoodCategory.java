package com.foodie.food.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "food_service_category")
@AllArgsConstructor
@NoArgsConstructor
public class FoodCategory {
    @Id
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodEntity> foodItems = new ArrayList<>();
}
