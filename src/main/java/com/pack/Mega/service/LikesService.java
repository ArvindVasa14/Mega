package com.pack.Mega.service;

import com.pack.Mega.model.Likes;
import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    public Likes addLikes(int userId, int postId){
        Likes likes= new Likes();
        Post post= postService.getPost(postId);
        likes.setPost(post);
        User user= userService.getUser(userId);
        likes.setLikedUser(user);

        return likesRepository.save(likes);
    }

}
