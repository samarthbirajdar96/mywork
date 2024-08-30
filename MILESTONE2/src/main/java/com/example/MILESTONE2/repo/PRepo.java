package com.example.MILESTONE2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MILESTONE2.model.Post;

@Repository
public interface PRepo  extends JpaRepository<Post, Long>{

}


