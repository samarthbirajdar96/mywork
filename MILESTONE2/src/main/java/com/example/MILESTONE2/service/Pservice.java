package com.example.MILESTONE2.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MILESTONE2.model.Post;
import com.example.MILESTONE2.repo.PRepo;

@Service
public class Pservice {

	
	@Autowired
	PRepo prepo;
	

	    public Post savePost(Post post) {
	        return prepo.save(post);
	    }

	    public Post getPostById(Long postId) {
	        return prepo.findById(postId).orElse(null);
	    }

	    public Post updatePost(Long postId, Post post) {
	        if (prepo.existsById(postId)) {
	            post.setId(postId);
	            return prepo.save(post);
	        }
	        return null;
	    }

	    public boolean deletePost(Long postId) {
	        if (prepo.existsById(postId)) {
	        	prepo.deleteById(postId);
	            return true;
	        }
	        return false;
	    }
	}

	

	


