package com.devskiller.tasks.blog.service;

import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.repository.PostRepo;

@Service
public class PostService {

	private final PostRepo postRepository;

	public PostService(PostRepo postRepository) {
		this.postRepository = postRepository;
	}

	public PostDto getPost(Long id) {
		return postRepository.findById(id)
				.map(post -> new PostDto(post.getTitle(), post.getContent(), post.getCreationDate()))
				.orElse(null);
	}
}
