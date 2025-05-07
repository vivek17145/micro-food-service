package com.foodie.feedback.service.impl;

import com.foodie.feedback.dto.FeedbackDto;
import com.foodie.feedback.modal.FeedbackEntity;
import com.foodie.feedback.repository.FeedbackRepository;
import com.foodie.feedback.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;


    // Get all feedback
    @Override
    public List<FeedbackDto> getAllFeedback() {
        return feedbackRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Get feedback by ID
    @Override
    public FeedbackDto getFeedbackById(String id) {
        FeedbackEntity feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found with ID: " + id));
        return mapToDto(feedback);
    }

    // Submit feedback
    @Override
    public FeedbackDto submitFeedback(FeedbackDto feedbackDto) {
        FeedbackEntity feedback = mapToEntity(feedbackDto);
        feedback.setCreatedAt(LocalDateTime.now());
        FeedbackEntity savedFeedback = feedbackRepository.save(feedback);
        return mapToDto(savedFeedback);
    }

    // Delete feedback
    @Override
    public void deleteFeedback(String id) {
        feedbackRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private FeedbackDto mapToDto(FeedbackEntity feedback) {
        return new FeedbackDto(
                feedback.getId(),
                feedback.getUserId(),
                feedback.getRestaurantId(),
                feedback.getRating(),
                feedback.getComments(),
                feedback.getCreatedAt()
        );
    }

    // Convert DTO to Entity
    private FeedbackEntity mapToEntity(FeedbackDto feedbackDto) {
        return new FeedbackEntity(
                feedbackDto.getId(),
                feedbackDto.getUserId(),
                feedbackDto.getRestaurantId(),
                feedbackDto.getRating(),
                feedbackDto.getComments(),
                feedbackDto.getCreatedAt()
        );
    }
}

