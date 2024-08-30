package com.example.MILESTONE2.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MILESTONE2.model.Comment;

@Repository
public interface CRepo  extends JpaRepository<Comment, Long>{

	    List<Comment> findByPostIdOrderByCreatedDateDesc(Long postId);
	}

	
	



