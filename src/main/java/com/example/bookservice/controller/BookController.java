package com.example.bookservice.controller;
import com.example.bookservice.Model.Book;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
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
       /* private final List<Book> books = new ArrayList<>();

        // Constructor to preload some books
        public BookController() {
            books.add(new Book(1, "Clean Code", "Robert C. Martin"));
            books.add(new Book(2, "Spring in Action", "Craig Walls"));
            books.add(new Book(3, "Effective Java", "Joshua Bloch"));
        }*/
    @Autowired
    private BookService bookService;
    @GetMapping
        public List<Book> getAllBooks() {
            return bookService.getAllBooks();
        }

       /*@PostMapping
        public Book addBook(@RequestBody Book book) {
            *//*books.add(book); // Add to the in-memory list
            return book; *//*    // Echo back the added book
           return bookService.addBook(book);
        }*/
       @PostMapping
       public Map<String, Object> addBook(@RequestBody Book book) {
           Book addedBook = bookService.addBook(book);
           Map<String, Object> response = new HashMap<>();
           response.put("message", "✅ Book added successfully!");
           response.put("bookAdded", addedBook);
           response.put("totalBooks", bookService.getAllBooks().size());
           return response;
       }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    @PutMapping("/{id}")
    public Map<String, Object> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(id, updatedBook);
        Map<String, Object> response = new HashMap<>();
        if (book != null) {
            response.put("message", "✅ Book updated successfully!");
            response.put("updatedBook", book);
        } else {
            response.put("message", "❌ Book not found with ID: " + id);
        }
        return response;
    }
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteBook(@PathVariable int id) {
        boolean isDeleted = bookService.deleteBook(id);
        Map<String, Object> response = new HashMap<>();
        if (isDeleted) {
            response.put("message", "✅ Book deleted successfully!");
            response.put("totalBooks", bookService.getAllBooks().size());
        } else {
            response.put("message", "❌ Book not found with ID: " + id);
        }
        return response;
    }


}
