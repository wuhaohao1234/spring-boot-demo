package com.example.demo.controller;

import com.example.demo.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class BookController {
    private List<Book> books = new ArrayList<>();
    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(books);
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<List<Book>> deleteBookById(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBookByName() {
        return ResponseEntity.ok(books);
    }
}
