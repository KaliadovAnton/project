package com.anton.converter;

import com.anton.dto.FeedbackDTO;
import com.anton.model.Feedback;
import com.anton.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackConverter {

    private FeedbackService feedbackService;

    public FeedbackDTO getFeedbackDTO(Long id){
        Feedback feedback = feedbackService.getFeedbackById(id);
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setDate(feedback.getDate());
        feedbackDTO.setRate(feedback.getRate());
        feedbackDTO.setText(feedback.getText());
        feedbackDTO.setTicketId(feedback.getTicket().getId());
        feedbackDTO.setUserId(feedback.getUser().getId());
        return feedbackDTO;
    }

    public List<FeedbackDTO> getListOfFeedbackDTO(){
        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        for(Feedback feedback: feedbackService.getListOfFeedbacks()){
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setDate(feedback.getDate());
            feedbackDTO.setRate(feedback.getRate());
            feedbackDTO.setText(feedback.getText());
            feedbackDTO.setTicketId(feedback.getTicket().getId());
            feedbackDTO.setUserId(feedback.getUser().getId());
            feedbackDTOList.add(feedbackDTO);
        }
        return feedbackDTOList;
    }
}
