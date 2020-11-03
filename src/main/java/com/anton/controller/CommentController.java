package com.anton.controller;

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

    @GetMapping()
    public ResponseEntity<List<Comment>> getListOfComments(){
        List<Comment> comment = commentService.getListOfComments();
        return ResponseEntity.ok().body(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody Comment Comment){
        commentService.addComment(Comment);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable("id") Long id, Comment ticket){

    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(commentService.getCommentById(id));
    }
}
