package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.repository.CommentRepo;
import io.micrometer.core.annotation.Timed;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;

@Service
public class CommentService {

	
	@Autowired
	CommentRepo commentRepository;


	

	@Timed(value = "getCommentsForPost.time", description = "Time taken to fetch comments")
	public List<CommentDto> getCommentsForPost(Long postId) {
		return
			this.commentRepository
				.findByPostId(postId)
				.stream()
				.map(cm ->
				new CommentDto(cm.getId(),cm.getComment(),cm.getAuthor(),cm.getCreationDate()))
			
				.sorted(Comparator.comparing(CommentDto::creationDate).reversed())
				.collect(Collectors.toList());
	}


	@Transactional
	public Long addComment(Long postId, NewCommentDto newCommentDto) {
			Comment comment = new Comment();
			comment.setPostId(postId);
			comment.setAuthor(newCommentDto.author());
			comment.setComment(newCommentDto.content());
			comment.setCreationDate(LocalDateTime.now());
			commentRepository.save(comment);
			return comment.getId();
	}
}
