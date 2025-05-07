package com.foodie.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
//@AllArgsConstructor
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    @ElementCollection
    List<String> pictureList = new ArrayList<>();
    private boolean isOpen;
    private LocalTime openTime;
    private LocalTime closeTime;
    @Lob
    private String description;
}
