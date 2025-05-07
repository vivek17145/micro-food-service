package com.foodie.food.service.impl;

import com.foodie.food.dto.FoodDTO;
import com.foodie.food.dto.RestaurantDto;
import com.foodie.food.modal.FoodCategory;
import com.foodie.food.modal.FoodEntity;
import com.foodie.food.repository.FoodCategoryRepository;
import com.foodie.food.repository.FoodRepository;
import com.foodie.food.service.FoodService;
import com.foodie.food.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodCategoryRepository categoryRepository;
//    api calling with restTemplate
    @Autowired
    private RestTemplate restTemplate;
//    api calling with Feign client
    @Autowired
    private RestaurantService restaurantService;
//    api calling with WebClient
    @Autowired
    private WebClient webClient;

    @Override
    @Transactional()
    public FoodDTO saveFood(FoodDTO foodDTO) {
        FoodEntity foodEntity = mapToEntity(foodDTO);
        foodEntity.setId(UUID.randomUUID().toString());
        FoodEntity savedEntity = foodRepository.save(foodEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public FoodDTO getFoodById(String id) {
        FoodEntity foodEntity = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        return mapToDTO(foodEntity);
    }

    @Override
    public List<FoodDTO> getAllFoods() {
        return foodRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodDTO> getFoodsByRestaurantId(String restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDTO updateFood(String id, FoodDTO foodDTO) {
        FoodEntity existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        existingFood.setTitle(foodDTO.getTitle());
        existingFood.setDescription(foodDTO.getDescription());
        existingFood.setQuantity(foodDTO.getQuantity());
        existingFood.setOutOfStock(foodDTO.getOutOfStock());
        existingFood.setFoodType(foodDTO.getFoodType());
//        existingFood.setFoodCategory(foodDTO.getFoodCategory());
        existingFood.setRestaurantId(foodDTO.getRestaurantId());
        return mapToDTO(foodRepository.save(existingFood));
    }

    @Override
    public void deleteFood(String id) {
        foodRepository.deleteById(id);
    }

    private FoodDTO mapToDTO(FoodEntity foodEntity) {
//        final RestaurantDto restaurantDto = restTemplate.getForObject("http://localhost:8091/api/v1/restaurants/" + foodEntity.getRestaurantId(), RestaurantDto.class);
//        final RestaurantDto restaurantDto = restaurantService.getRestaurantById(foodEntity.getRestaurantId());
        final RestaurantDto restaurantDto = webClient.get()
                .uri("/api/v1/restaurants/" + foodEntity.getRestaurantId())
                .retrieve().bodyToMono(RestaurantDto.class).block();

        return new FoodDTO(
                foodEntity.getId(),
                foodEntity.getTitle(),
                foodEntity.getDescription(),
                foodEntity.getQuantity(),
                foodEntity.getOutOfStock(),
                foodEntity.getFoodType(),
                foodEntity.getFoodCategory().getId(),
                foodEntity.getFoodCategory(),
                foodEntity.getRestaurantId(),
                restaurantDto
        );
    }

    private FoodEntity mapToEntity(FoodDTO foodDTO) {
        final Optional<FoodCategory> categoryOptional = categoryRepository.findById(foodDTO.getCategoryId());
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        return new FoodEntity(
                foodDTO.getId(),
                foodDTO.getTitle(),
                foodDTO.getDescription(),
                foodDTO.getQuantity(),
                foodDTO.getOutOfStock(),
                foodDTO.getFoodType(),
                categoryOptional.get(),
                foodDTO.getRestaurantId()
        );
    }
}