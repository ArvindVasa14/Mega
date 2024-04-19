package com.pack.Mega.service;

import com.pack.Mega.model.Comment;
import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentsRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    public Comment addComment(Comment comment, int postId, int commentedUserId){
        System.out.println("service "+postId + " "+ commentedUserId);
        Post post= postService.getPost(postId);
        comment.setPost(post);
        User user= userService.getUser(commentedUserId);
        comment.setCommentedUserId(user);

        System.out.println(comment.toString());
        return commentsRepository.save(comment);
    }

    public List<Comment> getComments(){
        return commentsRepository.findAll();
    }
}
