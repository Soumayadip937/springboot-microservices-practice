package com.example.bookservice.controller;

import com.example.bookservice.Model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RestController
public class BookController {
    /*@GetMapping("/books/first")
    public Book getFirstBook() {
        return getAllBooks().get(0);
    }*/
    /*@PostMapping("/books/first")
    public Book echoBook(@RequestBody Book book) {
        return book;  // this will return what you send in Postman
    }
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book(1, "Clean Code", "Robert C. Martin"),
                new Book(2, "Spring in Action", "Craig Walls"),
                new Book(3, "Effective Java", "Joshua Bloch")
        );
    *//*@GetMapping("/book")
    public Book getOneBook() {
        return new Book(9, "Java Puzzlers", "Joshua Bloch");
    }*//*
    }*/
        // In-memory storage
        private final List<Book> books = new ArrayList<>();

        // Constructor to preload some books
        public BookController() {
            books.add(new Book(1, "Clean Code", "Robert C. Martin"));
            books.add(new Book(2, "Spring in Action", "Craig Walls"));
            books.add(new Book(3, "Effective Java", "Joshua Bloch"));
        }

    @GetMapping("/book")
        public List<Book> getAllBooks() {
            return books;
        }

    @PostMapping("/books/first")
        public Book addBook(@RequestBody Book book) {
            books.add(book); // Add to the in-memory list
            return book;     // Echo back the added book
        }
    }
