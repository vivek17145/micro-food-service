package com.foodie.food.service.impl;

import com.foodie.food.dto.FoodCategoryDTO;
import com.foodie.food.dto.FoodDTO;
import com.foodie.food.dto.RestaurantDto;
import com.foodie.food.modal.FoodCategory;
import com.foodie.food.repository.FoodCategoryRepository;
import com.foodie.food.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FoodCategoryDTO saveCategory(FoodCategoryDTO categoryDTO) {
        FoodCategory category = new FoodCategory();
        category.setId(UUID.randomUUID().toString());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return mapToDTO(foodCategoryRepository.save(category));
    }

    @Override
    public FoodCategoryDTO getCategoryById(String id) {
        FoodCategory category = foodCategoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        return mapToDTO(category);
    }

    @Override
    public List<FoodCategoryDTO> getAllCategories() {
        return foodCategoryRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public FoodCategoryDTO updateCategory(String id, FoodCategoryDTO categoryDTO) {
        FoodCategory category = foodCategoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return mapToDTO(foodCategoryRepository.save(category));
    }

    @Override
    public void deleteCategory(String id) {
        foodCategoryRepository.deleteById(id);
    }

    private FoodCategoryDTO mapToDTO(FoodCategory category) {
        final RestaurantDto restaurantDto = restTemplate.getForObject("http://localhost:8091/api/v1/restaurants/" + category.getFoodItems().get(0).getRestaurantId(), RestaurantDto.class);
        List<FoodDTO> foodItems = category.getFoodItems().stream()
            .map(food -> new FoodDTO(
                food.getId(),
                food.getTitle(),
                food.getDescription(),
                food.getQuantity(),
                food.getOutOfStock(),
                food.getFoodType(),
                food.getFoodCategory().getId(),
                food.getFoodCategory(),
                food.getRestaurantId(),
                restaurantDto
            ))
            .toList();
        
        return new FoodCategoryDTO(
            category.getId(),
            category.getName(),
            category.getDescription(),
            foodItems
        );
    }
}
