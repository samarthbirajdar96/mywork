package com.example.SpringRecativeWebFlux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

	
	@Autowired
    private BookRepository bookRepository;

   

    @GetMapping("books")
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
       
        @GetMapping("book/id/{id}")
        public Mono<Book> getBookById(@PathVariable String id) {
            return bookRepository.findById(id);
                    
        }

      
        @PostMapping("book")
        public Mono<Book> createBook(@RequestBody Book book) {
            return bookRepository.save(book);
        }

       
        @DeleteMapping("book/id/{id}")
        public Mono<Void> deleteBook(@PathVariable String id) {
            return bookRepository.deleteById(id);
                    
        }
    }



