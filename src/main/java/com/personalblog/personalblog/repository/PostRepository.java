package com.personalblog.personalblog.repository;

import com.personalblog.personalblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
