package com.pack.Mega.service;

import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.PostRepository;
import com.pack.Mega.service.PostService;
import com.pack.Mega.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PostServiceTest {

    @Mock
    private PostRepository postsRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addPost_Returns_Post(){
        Post post=new Post();
        post.setPostText("Hello");
        int userId=1;
        User duser=new User();
        duser.setUserId(1);
        duser.setUserName("Ramu");
        when(userService.getUser(userId)).thenReturn(duser);
        User user= userService.getUser(userId);
        post.user= user;
        when(postsRepository.save(post)).thenReturn(post);

        Post rpost=postService.addPost(post,userId);
        assertEquals(post,rpost);

    }
    @Test
    public void getPosts_Retruns_ListPost(){
        Post post=new Post();
        post.setPostId(1);
        post.setPostText("Hello");
        Post post1=new Post();
        post1.setPostId(1);
        post1.setPostText("Hello1");
        ArrayList<Post>  posts=new ArrayList<>();
        posts.add(post);
        posts.add(post1);
        when(postsRepository.findAll()).thenReturn(posts);
        List<Post> rposts=postService.getPosts();

        assertEquals(posts,rposts);
    }

    @Test
    public void getPost_Returns_Post(){
        Post post=new Post();
        post.setPostId(1);
        post.setPostText("Hello");
        int postId=1;
        when(postsRepository.findById(postId)).thenReturn(Optional.of(post));
        Post rpost=postService.getPost(postId);
        assertEquals(post.postId,rpost.postId);
        assertEquals(post.postText,rpost.postText);
    }
}
