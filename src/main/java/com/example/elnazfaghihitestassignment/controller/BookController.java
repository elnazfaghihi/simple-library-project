package com.example.elnazfaghihitestassignment.controller;

import com.example.elnazfaghihitestassignment.controller.routes.Routes;
import com.example.elnazfaghihitestassignment.model.Book;
import com.example.elnazfaghihitestassignment.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Routes.BOOK_CONTROLLER)
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/available-books")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAvailableBooks());
    }

    @GetMapping("/user-borrowed")
    public ResponseEntity<List<Book>> getUserBorrowedBooksAtSpecificDateRange(@RequestParam(value = "userId") Long userId, @RequestParam(value = "from") Date from, @RequestParam(value = "to") Date to) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getUserBorrowedBooksAtSpecificDateRange(userId, from, to));
    }
}
