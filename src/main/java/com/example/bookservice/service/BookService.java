package com.example.bookservice.service;

import com.example.bookservice.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Spring in Action", "Craig Walls"));
        books.add(new Book(3, "Effective Java", "Joshua Bloch"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
