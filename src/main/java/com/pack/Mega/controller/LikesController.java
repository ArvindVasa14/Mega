package com.pack.Mega.controller;

import com.pack.Mega.model.Likes;
import com.pack.Mega.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    LikesService likesService;

    @PostMapping("/user/{likedUserId}/post/{postId}")
    public Likes addLikes(@PathVariable int likedUserId, @PathVariable int postId){
        return likesService.addLikes(likedUserId, postId);
    }
}
