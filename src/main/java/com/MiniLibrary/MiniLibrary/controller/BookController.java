
package com.MiniLibrary.MiniLibrary.controller;

import com.MiniLibrary.MiniLibrary.model.Book;
import com.MiniLibrary.MiniLibrary.repository.BookRepository;
import com.MiniLibrary.MiniLibrary.service.GoogleBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final GoogleBooksService googleBooksService;
    private final BookRepository bookRepository;

    public BookController(
            GoogleBooksService googleBooksService,
            BookRepository bookRepository) {
        this.googleBooksService = googleBooksService;
        this.bookRepository = bookRepository;
    }

    // Search books using Google Books API
    @GetMapping("/search")
    public String searchBooks(@RequestParam String query) {
        return googleBooksService.searchBooks(query);
    }

    // Save a book to PostgreSQL
   
@PostMapping("/save")
public Book saveBook(@RequestBody Book book) {

    if (book.getGoogleBooksId() != null
            && bookRepository.existsByGoogleBooksId(book.getGoogleBooksId())) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "This book is already in your library."
        );
    }

    return bookRepository.save(book);
}


    // View all saved books
    @GetMapping("/saved")
    public List<Book> getSavedBooks() {
        return bookRepository.findAll();
    }

    // Delete a saved book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    
    // Update a book's reading status
    @PatchMapping("/{id}/status")
    public Book updateBookStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        String newStatus = status.trim().toUpperCase();

        if (!List.of("WANT_TO_READ", "READING", "COMPLETED")
                .contains(newStatus)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Status must be WANT_TO_READ, READING, or COMPLETED"
            );
        }

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Book not found"
                ));

        book.setStatus(newStatus);
        return bookRepository.save(book);
    }

}
