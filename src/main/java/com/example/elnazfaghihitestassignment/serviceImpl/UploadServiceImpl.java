package com.example.elnazfaghihitestassignment.serviceImpl;

import com.example.elnazfaghihitestassignment.service.BookService;
import com.example.elnazfaghihitestassignment.service.BorrowedService;
import com.example.elnazfaghihitestassignment.service.UploadService;
import com.example.elnazfaghihitestassignment.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

    private final UserService userService;
    private final BookService bookService;
    private final BorrowedService borrowedService;

    public UploadServiceImpl(UserService userService, BookService bookService, BorrowedService borrowedService) {
        this.userService = userService;
        this.bookService = bookService;
        this.borrowedService = borrowedService;
    }

    @Override
    public void readFile(MultipartFile userCSVFile, MultipartFile bookCSVFile, MultipartFile borrowedCSVFile) {
        userService.addToDB(userCSVFile);
        bookService.addToDB(bookCSVFile);
        borrowedService.addToDB(borrowedCSVFile);

        userService.getUserListsWithAtLeastOneBorrowedBook();
    }
}
