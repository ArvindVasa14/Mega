package com.pack.Mega.model;

import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int postId;
    public String postText;
    public Blob postImage;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public User user;

    @OneToMany(mappedBy = "post")
    List<Comment> comments= new LinkedList<>();

    @OneToMany(mappedBy = "post")
    List<Likes> likes= new LinkedList<>();

}
