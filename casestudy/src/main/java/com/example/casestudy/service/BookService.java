package com.example.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudy.model.Book;
import com.example.casestudy.repo.BookRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
	
	private final BookRepo bookrepo;

    @Autowired
    public BookService(BookRepo bookrepo) {
        this.bookrepo = bookrepo;
    }

	  public Flux<Book> getAllBooks() {
	        return bookrepo.findAll();
	    }

	    public Flux<Book> searchBooksByTitle(String title) {
	        return bookrepo.findByTitleContainingIgnoreCase(title);
	    }

	    public Mono<Boolean> isBookInStock(Long bookId) {
	        return bookrepo.findById(bookId)
	                .map(Book::isInStock);
	    }
	    
	    public Mono<Book> addBook(Book book) {
	       return   bookrepo.save(book);
	         
	    }

}
