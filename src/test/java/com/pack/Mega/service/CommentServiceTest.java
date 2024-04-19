package com.pack.Mega.service;

import com.pack.Mega.controller.CommentController;
import com.pack.Mega.model.Comment;
import com.pack.Mega.model.Post;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.CommentRepository;
import com.pack.Mega.service.CommentService;
import com.pack.Mega.service.PostService;
import com.pack.Mega.service.UserService;
import org.hibernate.annotations.Comments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;


    @Mock
    private UserService userService;

    @Mock
    private PostService postService;


    @InjectMocks
    private CommentService commentService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addComment_Returns_Comment(){
        Comment comment=new Comment();
        comment.setCommentId(1);
        comment.setComment("Good");
        int postId=1;
        int commentedUserId=3;
        Post post=new Post();
        post.setPostText("hello");
        post.setPostId(1);
        when(postService.getPost(postId)).thenReturn(post);
        Post rpost= postService.getPost(postId);
        comment.setPost(rpost);
        User cuser=new User();
        cuser.setUserId(3);
        cuser.setUserName("Aravind");
        when(userService.getUser(commentedUserId)).thenReturn(cuser);
        User ruser= userService.getUser(commentedUserId);
        comment.setCommentedUserId(ruser);
        when(commentRepository.save(comment)).thenReturn(comment);
        Comment rcomment=commentService.addComment(comment,postId,commentedUserId);
        assertEquals(comment,rcomment);

    }

    @Test
    public void getCommentsReturns_Comments(){
        Comment comment1=new Comment();
        Comment comment2=new Comment();
        comment1.setCommentId(1);
        comment1.setComment("Good");

        comment2.setCommentId(2);
        comment2.setComment("very Good");

        List<Comment> comments =new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        when(commentRepository.findAll()).thenReturn(comments);
        List<Comment> rcomments=commentService.getComments();
        assertEquals(comments,rcomments);

    }
}
