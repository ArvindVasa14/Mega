package com.pack.Mega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cid; // comment id
    public String comment; 
    public String pid; // post id
    public String puid; // posted by user ID
    public String cuid; // commented by user ID

    
}
