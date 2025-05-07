package com.foodie.feedback.service;

import com.foodie.feedback.dto.FeedbackDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedbackService {
    List<FeedbackDto> getAllFeedback();
    FeedbackDto getFeedbackById(String id);
    FeedbackDto submitFeedback(FeedbackDto feedbackDto);
    void deleteFeedback(String id);
}

