package com.anton.service;

import com.anton.model.Comment;
import com.anton.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
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
        return commentRepository.getCommentById(id).orElseThrow(()->new NoResultException("No comment with id "+id));
    }

    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    public void updateComment(Long id, Comment comment) {
        commentRepository.updateComment(id, comment);
    }
}
