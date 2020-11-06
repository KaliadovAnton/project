package com.anton.service;

import com.anton.model.Feedback;
import com.anton.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.getFeedbackById(id).orElseThrow(()->new NoResultException("There s no feedback with id "+id));
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteFeedback(id);
    }

    public List<Feedback> getListOfFeedbacks() {
        return feedbackRepository.getAllFeedbacks();
    }

    public void addFeedback(Feedback feedback) {
        feedbackRepository.addFeedback(feedback);
    }

    public void updateFeedback(Long id, Feedback feedback) {
        feedbackRepository.updateFeedback(id, feedback);
    }
}
