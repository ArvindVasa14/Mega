package com.pack.Mega.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int pid;
    public String postText;
    public Blob postImage;
    public int likes;

    @ManyToOne
    public int uid;
}
