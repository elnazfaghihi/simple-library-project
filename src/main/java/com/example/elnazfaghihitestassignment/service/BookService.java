package com.example.elnazfaghihitestassignment.service;

import com.example.elnazfaghihitestassignment.model.Book;

import java.util.Date;
import java.util.List;


public interface BookService extends BasicService {
   Book findBookByTitle(String title);
   List<Book> getAvailableBooks();
   List<Book> getUserBorrowedBooksAtSpecificDateRange(Long userId, Date from, Date to);
}
