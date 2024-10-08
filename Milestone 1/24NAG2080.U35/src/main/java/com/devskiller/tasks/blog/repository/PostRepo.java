package com.devskiller.tasks.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devskiller.tasks.blog.model.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
