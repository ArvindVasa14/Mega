package com.pack.Mega.repository;

import com.pack.Mega.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
