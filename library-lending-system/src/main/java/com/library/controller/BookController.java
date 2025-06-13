package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return ResponseEntity.ok(bookService.update(book));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('MEMBER')")
    @PostMapping("/borrow/{id}")
    public ResponseEntity<Void> borrowBook(@PathVariable Long id) {
        // TODO: Implement borrow logic
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('MEMBER')")
    @PostMapping("/return/{id}")
    public ResponseEntity<Void> returnBook(@PathVariable Long id) {
        // TODO: Implement return logic
        return ResponseEntity.ok().build();
    }
}
