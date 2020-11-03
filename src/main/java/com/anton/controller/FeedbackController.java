package com.anton.controller;

import com.anton.model.Feedback;
import com.anton.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping()
    public ResponseEntity<List<Feedback>> getListOfFeedbacks(){
        List<Feedback> Feedback = feedbackService.getListOfFeedbacks();
        return ResponseEntity.ok().body(Feedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable("id") Long id){
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveFeedback(@RequestBody Feedback Feedback){
        feedbackService.addFeedback(Feedback);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateFeedback(@PathVariable("id") Long id, Feedback Feedback){

    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(feedbackService.getFeedbackById(id));
    }
}
