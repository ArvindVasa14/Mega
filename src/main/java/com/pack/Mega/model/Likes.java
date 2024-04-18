package com.pack.Mega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    public int likeId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    public Post post;

//    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public User likedUser;

	public void setPost(Post post2) {
		this.post=post2;
		
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public User getLikedUser() {
		return likedUser;
	}

	public void setLikedUser(User likedUser) {
		this.likedUser = likedUser;
	}

	public Post getPost() {
		return post;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", post=" + post + ", likedUser=" + likedUser + "]";
	}
	

}
