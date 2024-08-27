package com.example.casestudy.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Book {

    @Id
    private Long id;
    private String title;
    private String author;
    private double price;
    private boolean inStock;

    // Constructors
    public Book() {}

    public Book(Long id, String title, String author, double price, boolean inStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}


   
   
