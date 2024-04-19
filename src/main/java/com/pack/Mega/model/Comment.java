package com.pack.Mega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getCommentedUserId() {
		return commentedUserId;
	}

	public void setCommentedUserId(User commentedUserId) {
		this.commentedUserId = commentedUserId;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int commentId;
    public String comment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "postId")
    public Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commented_user", referencedColumnName = "userId")
    public User commentedUserId;


}
