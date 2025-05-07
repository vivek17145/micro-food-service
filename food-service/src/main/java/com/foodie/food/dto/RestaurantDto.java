package com.foodie.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private List<String> pictureList;
    private boolean isOpen;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String description;
}