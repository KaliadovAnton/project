package com.anton.converter;

import com.anton.dto.CommentDTO;
import com.anton.model.Comment;
import com.anton.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentConverter {

    @Autowired
    private CommentService commentService;

    public CommentDTO getCommentDTO(Long id){
        Comment comment = commentService.getCommentById(id);
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setDate(comment.getDate());
        commentDTO.setText(comment.getText());
        commentDTO.setTicketId(comment.getTicket().getId());
        commentDTO.setUserId(comment.getUser().getId());
        return commentDTO;
    }

    public List<CommentDTO> getListOfCommentDTO(){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(Comment comment: commentService.getListOfComments()){
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setDate(comment.getDate());
            commentDTO.setText(comment.getText());
            commentDTO.setTicketId(comment.getTicket().getId());
            commentDTO.setUserId(comment.getUser().getId());
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }
}
