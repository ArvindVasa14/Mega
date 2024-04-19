package com.pack.Mega.controller;

import com.pack.Mega.model.Comment;
import com.pack.Mega.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("{postId}/addComment/{commentedUserId}")
    public ResponseEntity<?> addComment(@RequestBody Comment comment, @PathVariable int postId, @PathVariable int commentedUserId){
        System.out.println("controller "+postId + " "+ commentedUserId);
        return new ResponseEntity<>(commentService.addComment(comment, postId, commentedUserId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getComments")
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }

}
