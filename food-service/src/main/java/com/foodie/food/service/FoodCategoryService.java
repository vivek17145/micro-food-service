package com.foodie.food.service;

import com.foodie.food.dto.FoodCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FoodCategoryService {
    FoodCategoryDTO saveCategory(FoodCategoryDTO categoryDTO);
    FoodCategoryDTO getCategoryById(String id);
    List<FoodCategoryDTO> getAllCategories();
    FoodCategoryDTO updateCategory(String id, FoodCategoryDTO categoryDTO);
    void deleteCategory(String id);
}
