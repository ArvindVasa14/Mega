package com.pack.Mega.model;

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
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cid; // comment id
    public String comment; 
    public String pid; // post id
    public String puid; // posted by user ID
    public String cuid; // commented by user ID

    @ManyToOne
    @JoinColumn(name = "commentList")
    private Post post;

    
}
