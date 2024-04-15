package com.pack.Mega.model;

import java.sql.Blob;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer pid;
    public String postText;
    public Blob postImage;
    public int likes;

    @ManyToOne
    @JoinColumn(name = "uid")
    private UserDetail user;


    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> commentList;


    @OneToMany(mappedBy = "pid",cascade = CascadeType.ALL)
    private List<Like> likeList;



}
