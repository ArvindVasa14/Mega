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
    public String userPassword;
    public String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    public List<Post> posts= new LinkedList<>();
}