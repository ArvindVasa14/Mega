package com.pack.Mega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userDetails")
public class UserDetail{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int uid;
    public String uname;
    public String upass;
    public String role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    public List<Post> postIds ;

    @OneToMany(mappedBy = "luid",cascade = CascadeType.ALL)
    public List<Like> likeList;
}