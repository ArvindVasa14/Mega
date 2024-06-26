package com.pack.Mega.service;

import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    public PostRepository postsRepository;

    @Autowired UserService userService;

    public Post addPost(Post post, int userId){
        User user= userService.getUser(userId);
        post.user= user;
        return postsRepository.save(post);
    }

    public List<Post> getPosts(){
        return postsRepository.findAll();
    }

    public Post getPost(int postId){
        System.out.println(postId);
        Optional<Post> postOptional= postsRepository.findById(postId);
        Post post= new Post();
        if (postOptional.isPresent()){
            post= postOptional.get();
            System.out.println(post.getPostId());
        }
        return post;
    }
}
