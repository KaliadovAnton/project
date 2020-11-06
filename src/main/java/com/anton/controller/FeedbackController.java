package com.anton.controller;

import com.anton.converter.FeedbackConverter;
import com.anton.dto.FeedbackDTO;
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
    @Autowired
    private FeedbackConverter feedbackConverter;

    @GetMapping()
    public ResponseEntity<List<FeedbackDTO>> getListOfFeedbacks(){
        List<FeedbackDTO> feedbackDTO = feedbackConverter.getListOfFeedbackDTO();
        return ResponseEntity.ok().body(feedbackDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable("id") Long id){
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveFeedback(@RequestBody Feedback feedback){
        feedbackService.addFeedback(feedback);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateFeedback(@PathVariable("id") Long id, Feedback feedback){
        feedbackService.updateFeedback(id, feedback);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(feedbackConverter.getFeedbackDTO(id));
    }
}
