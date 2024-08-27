package com.example.casestudy.repo;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.casestudy.model.Book;

import reactor.core.publisher.Flux;



public interface BookRepo extends ReactiveCrudRepository<Book, Long> {

	Flux<Book> findByTitleContainingIgnoreCase(String title);

}
