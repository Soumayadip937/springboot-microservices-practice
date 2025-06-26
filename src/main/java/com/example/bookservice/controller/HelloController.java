package com.example.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    //@GetMapping("/hello")
    @GetMapping("/wrong-url")
    public String sayHello() {
        //return "Hello from BookService!";
        return "Hello at " + LocalDateTime.now();
    }
    @GetMapping("/hi")
    public String sayHi() {
        return "Hi from Spring Boot!";
    }

}
