package com.foodie.restaurant.service.impl;

import com.foodie.restaurant.dto.RestaurantDto;
import com.foodie.restaurant.model.RestaurantEntity;
import com.foodie.restaurant.repository.RestaurantRepository;
import com.foodie.restaurant.service.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class RestaurantServiceImpl implements RestaurantService {
        @Autowired
        private RestaurantRepository restaurantRepository;

        // Convert DTO to Entity
        private RestaurantEntity toEntity(RestaurantDto dto) {
            RestaurantEntity entity = new RestaurantEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setAddress(dto.getAddress());
            entity.setContactNumber(dto.getContactNumber());
            entity.setEmail(dto.getEmail());
            entity.setPictureList(dto.getPictureList());
            entity.setOpen(dto.isOpen());
            entity.setOpenTime(dto.getOpenTime());
            entity.setCloseTime(dto.getCloseTime());
            entity.setDescription(dto.getDescription());
            return entity;
        }

        // Convert Entity to DTO
        private RestaurantDto toDto(RestaurantEntity entity) {
            RestaurantDto dto = new RestaurantDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setAddress(entity.getAddress());
            dto.setContactNumber(entity.getContactNumber());
            dto.setEmail(entity.getEmail());
            dto.setPictureList(entity.getPictureList());
            dto.setOpen(entity.isOpen());
            dto.setOpenTime(entity.getOpenTime());
            dto.setCloseTime(entity.getCloseTime());
            dto.setDescription(entity.getDescription());
            return dto;
        }

        // Create or Update a Restaurant
        public RestaurantDto saveOrUpdate(RestaurantDto dto) {
            RestaurantEntity entity = restaurantRepository.save(toEntity(dto));
            return toDto(entity);
        }

        // Get All Restaurants
        public List<RestaurantDto> getAllRestaurants() {
            return restaurantRepository.findAll()
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
        }

        // Get a Restaurant by ID
        public RestaurantDto getRestaurantById(String id) {
            Optional<RestaurantEntity> entity = restaurantRepository.findById(id);
            return entity.map(this::toDto).orElse(null);
        }

        // Delete a Restaurant
        public void deleteRestaurant(String id) {
            restaurantRepository.deleteById(id);
        }
    }
