package com.example.casestudy.service;



import org.springframework.stereotype.Service;

import com.example.casestudy.model.Book;

import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CartService {
    private final Map<Long, Book> cart = new ConcurrentHashMap<>();

    public Mono<Book> addBookToCart(Book book) {
        cart.put(book.getId(), book);
        return Mono.just(book);
    }

    public Mono<Book> removeBookFromCart(Long bookId) {
        return Mono.justOrEmpty(cart.remove(bookId));
    }

    public Mono<Map<Long, Book>> getCart() {
        return Mono.just(cart);
    }
}
