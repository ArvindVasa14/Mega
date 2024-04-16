package com.pack.Mega.controller;

import com.pack.Mega.model.Post;
import com.pack.Mega.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    public PostService postsService;

    @PostMapping("/addPost/{userId}")
    public ResponseEntity<?> addPost(@RequestBody Post post, @PathVariable int userId){
        return new ResponseEntity<>(postsService.addPost(post, userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getPosts")
    public ResponseEntity<?> getAllPosts(){
        return new ResponseEntity<>(postsService.getPosts(), HttpStatus.ACCEPTED);
    }


 }
