package com.example.MILESTONE2.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.MILESTONE2.model.Comment;
import com.example.MILESTONE2.model.Post;
import com.example.MILESTONE2.repo.CRepo;
import com.example.MILESTONE2.repo.PRepo;

import jakarta.transaction.Transactional;

@Service
public class CService {
	
	@Autowired
	CRepo crepo;

        @Autowired
	     PRepo prepo;

        public boolean addComment(Long postId, String commentContent) {
            Optional<Post> post = prepo.findById(postId);
            if (post.isPresent()) {
                Comment comment = new Comment();
                comment.setContent(commentContent);
                comment.setCreatedDate(LocalDateTime.now());
                comment.setPost(post.get());
                crepo.save(comment);
                return true;
            }
            return false;
        }

        public List<Comment> getComments(Long postId) {
            return crepo.findByPostIdOrderByCreatedDateDesc(postId);
        }
    }






	


