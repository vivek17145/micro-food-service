package com.foodie.food.repository;

import com.foodie.food.modal.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, String> {
}
