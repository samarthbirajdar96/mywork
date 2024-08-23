package com.example.SpringRecativeWebFlux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
@WebFluxTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        // Mock the repository
        given(bookRepository.findAll()).willReturn(Flux.just(
            new Book("Book 1", "Author 1"),
            new Book("Book 2", "Author 2")
        ));
        given(bookRepository.findById("1")).willReturn(Mono.just(new Book("Book 1", "Author 1")));
        given(bookRepository.findById("2")).willReturn(Mono.empty());
        given(bookRepository.save(new Book("Book 3", "Author 3"))).willReturn(Mono.just(new Book("Book 3", "Author 3")));
    }



	



	@Test
    public void testGetAllBooks() {
        webTestClient.get().uri("/books")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Book.class)
            .hasSize(2);
    }

    @Test
    public void testGetBookById() {
        webTestClient.get().uri("/books/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody(Book.class)
            .isEqualTo(new Book("Book 1", "Author 1"));
    }

    @Test
    public void testGetBookByIdNotFound() {
        webTestClient.get().uri("/books/2")
            .exchange()
            .expectStatus().isNotFound();
    }

    @Test
    public void testCreateBook() {
        Book newBook = new Book("Book 3", "Author 3");

        webTestClient.post().uri("/books")
            .bodyValue(newBook)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Book.class)
            .isEqualTo(newBook);
    }

    @Test
    public void testDeleteBook() {
        webTestClient.delete().uri("/books/1")
            .exchange()
            .expectStatus().isNoContent();
    }

    @Test
    public void testDeleteBookNotFound() {
        webTestClient.delete().uri("/books/2")
            .exchange()
            .expectStatus().isNotFound();
    }
}
