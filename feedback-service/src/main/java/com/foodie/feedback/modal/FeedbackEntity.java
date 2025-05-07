package com.foodie.feedback.modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId; // The user who gave the feedback

    private String restaurantId; // The restaurant being reviewed

    private int rating; // Rating out of 5

    @Lob
    private String comments; // Feedback comments

    private LocalDateTime createdAt; // Date & time of feedback submission
}

