package com.pack.Mega.model;

import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    
    public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Blob getPostImage() {
		return postImage;
	}

	public void setPostImage(Blob postImage) {
		this.postImage = postImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

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

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postText=" + postText + ", postImage=" + postImage + ", user=" + user
				+ ", comments=" + comments + ", likes=" + likes + "]";
	}

    
}
