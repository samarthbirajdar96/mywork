package com.example.MILESTONE2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MILESTONE2.model.Comment;
import com.example.MILESTONE2.service.CService;



@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
	
	@Autowired

	CService cservice ;
	
	

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

