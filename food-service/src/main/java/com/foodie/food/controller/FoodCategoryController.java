package com.foodie.food.controller;

import com.foodie.food.dto.FoodCategoryDTO;
import com.foodie.food.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-categories")
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    @Autowired
    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    // Create a new food category
    @PostMapping("/create")
    public ResponseEntity<FoodCategoryDTO> createCategory(@RequestBody FoodCategoryDTO categoryDTO) {
        FoodCategoryDTO createdCategory = foodCategoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Get food category by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodCategoryDTO> getCategoryById(@PathVariable String id) {
        FoodCategoryDTO categoryDTO = foodCategoryService.getCategoryById(id);
        return categoryDTO != null
                ? new ResponseEntity<>(categoryDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all food categories
    @GetMapping("/all")
    public ResponseEntity<List<FoodCategoryDTO>> getAllCategories() {
        List<FoodCategoryDTO> categories = foodCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Update an existing food category
    @PutMapping("/{id}")
    public ResponseEntity<FoodCategoryDTO> updateCategory(
            @PathVariable String id, @RequestBody FoodCategoryDTO categoryDTO) {
        FoodCategoryDTO updatedCategory = foodCategoryService.updateCategory(id, categoryDTO);
        return updatedCategory != null
                ? new ResponseEntity<>(updatedCategory, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a food category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        foodCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
