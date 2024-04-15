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
@Table(name="likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int lid;

    @ManyToOne
    @JoinColumn(name="pid")
    public Post pid;

    @ManyToOne
    @JoinColumn(name = "luid")
    public UserDetail luid;
    
}
