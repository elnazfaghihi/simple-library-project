package com.example.elnazfaghihitestassignment.serviceImpl;

import com.example.elnazfaghihitestassignment.dto.BookDTO;
import com.example.elnazfaghihitestassignment.helper.BookCSVHelper;
import com.example.elnazfaghihitestassignment.model.Author;
import com.example.elnazfaghihitestassignment.model.Book;
import com.example.elnazfaghihitestassignment.repository.BookRepository;
import com.example.elnazfaghihitestassignment.service.AuthorService;
import com.example.elnazfaghihitestassignment.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookCSVHelper bookCsvHelper;
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookCSVHelper bookCsvHelper, BookRepository bookRepository, AuthorService authorService) {
        this.bookCsvHelper = bookCsvHelper;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Transactional
    @Override
    public void addToDB(MultipartFile csvFile) {
        List<BookDTO> bookDTOS = bookCsvHelper.readFile(csvFile);
        List<Book> books = bookDTOS.stream().map(BookDTO::toModel).map(this::saveAuthor).collect(Collectors.toList());
        bookRepository.saveAll(books);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title).orElseThrow(() -> new IllegalStateException("Book not found."));
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.getAvailableBooks();
    }

    @Override
    public List<Book> getUserBorrowedBooksAtSpecificDateRange(Long userId, Date from, Date to) {
        return bookRepository.getUserBorrowedBooksAtSpecificDateRange(userId, from, to);
    }

    private Book saveAuthor(Book book) {
        Set<Author> authors = book.getAuthors();
        if (authors.size() > 0) {
            book.setAuthors(authors.stream().map(authorService::save).collect(Collectors.toSet()));
        }
        return book;
    }
}
