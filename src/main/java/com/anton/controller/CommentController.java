package com.anton.controller;

import com.anton.converter.CommentConverter;
import com.anton.dto.CommentDTO;
import com.anton.model.Comment;
import com.anton.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentConverter commentConverter;

    @GetMapping()
    public ResponseEntity<List<CommentDTO>> getListOfComments(){
        List<CommentDTO> comment = commentConverter.getListOfCommentDTO();
        return ResponseEntity.ok().body(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable("id") Long id, Comment comment){
        commentService.updateComment(id, comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(commentConverter.getCommentDTO(id));
    }
}
