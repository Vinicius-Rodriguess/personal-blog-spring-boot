package com.personalblog.personalblog.repository;

import com.personalblog.personalblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    public List <Post> findAllByTitleContainingIgnoreCase(@Param("title") String title);
}
