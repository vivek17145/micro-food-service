package com.foodie.feedback.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    private String id;
    private String userId;
    private String restaurantId;
    private int rating;
    private String comments;
    private LocalDateTime createdAt;
}

