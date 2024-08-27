package com.example.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudy.model.Book;
import com.example.casestudy.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
	
	
	 private final BookService bookService;

	    @Autowired
	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }
	
	@GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public Flux<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @PostMapping("/add")
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}/inStock")
    public Mono<Boolean> isBookInStock(@PathVariable Long id) {
        return bookService.isBookInStock(id);
    }
}
	
	


