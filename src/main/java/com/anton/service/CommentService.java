package com.anton.service;

import com.anton.model.Comment;
import com.anton.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getListOfComments() {
        return commentRepository.getAllComments();
    }

    public void deleteComment(Long id) {
        commentRepository.deleteComment(id);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }

    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }
}
