package com.pack.Mega.service;

import com.pack.Mega.model.Likes;
import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.LikesRepository;
import com.pack.Mega.service.LikesService;
import com.pack.Mega.service.PostService;
import com.pack.Mega.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LikesServiceTest {

    @Mock
    private LikesRepository likesRepository;

    @Mock
    private PostService postService;
//# post service
    @Mock
    private UserService userService;

    @InjectMocks
    private LikesService likesService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addLikes(){
        int postId=1;
        int userId=2;
        Likes likes= new Likes();
        likes.setLikeId(1);
        Post post=new Post();
        post.setPostId(1);
        post.setPostText("hello");

        User puser=new User();
        puser.setUserId(1);
        puser.setUserName("Ramu");
        post.setUser(puser);

        User luser=new User();
        luser.setUserId(2);
        luser.setUserName("Nithin");

        when(postService.getPost(postId)).thenReturn(post);
        //Post rpost= postService.getPost(postId);
        likes.setPost(post);
        when(userService.getUser(userId)).thenReturn(luser);
        //User user= userService.getUser(userId);
        likes.setLikedUser(luser);

        when(likesRepository.save(any(Likes.class))).thenReturn(likes);

        Likes rlikes=likesService.addLikes(postId,userId);

        assertEquals(likes,rlikes);
    }

}
