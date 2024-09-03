package com.example.MILESTONE2.controller;

import java.util.List;


import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.MILESTONE2.model.Comment;
import com.example.MILESTONE2.model.Post;
import com.example.MILESTONE2.service.CService;
import com.example.MILESTONE2.service.Pservice;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	Pservice pservice;
	
	@Autowired
	CService cservice ;
	
 
	  @PostMapping
	    public ResponseEntity<Post> createPost(@RequestBody Post post) {
	        Post createdPost = pservice.savePost(post);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Post> getPostById(@PathVariable("id") Long postId) {
	        Post post = pservice.getPostById(postId);
	        if (post != null) {
	            return ResponseEntity.ok(post);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Post> updatePost(@PathVariable("id") Long postId, @RequestBody Post post) {
	        Post updatedPost = pservice.updatePost(postId, post);
	        if (updatedPost != null) {
	            return ResponseEntity.ok(updatedPost);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePost(@PathVariable("id") Long postId) {
	        boolean isDeleted = pservice.deletePost(postId);
	        if (isDeleted) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @PostMapping("/{id}/comments")
	    public ResponseEntity<Void> addComment(@PathVariable("id") Long postId, @RequestBody String commentContent) {
	        boolean isCreated = cservice.addComment(postId, commentContent);
	        if (isCreated) {
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @GetMapping("/{id}/comments")
	    public ResponseEntity<List<Comment>> getComments(@PathVariable("id") Long postId) {
	        List<Comment> comments = cservice.getComments(postId);
	        if (comments.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(comments);
	        }
	    }
	}


