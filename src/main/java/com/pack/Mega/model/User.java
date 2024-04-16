package com.pack.Mega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;
    public String userName;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    public List<Post> posts= new LinkedList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "commentedUserId")
    public List<Comment> comments= new LinkedList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "likedUser")
    public List<Likes> likes= new LinkedList<>();
}