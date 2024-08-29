package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

	public List<Comment> findByPostId(Long postId);
}
