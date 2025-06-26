package com.example.bookservice.controller;

import com.example.bookservice.Model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book(1, "Clean Code", "Robert C. Martin"),
                new Book(2, "Spring in Action", "Craig Walls"),
                new Book(3, "Effective Java", "Joshua Bloch")
        );
    }
}
