package com.example.elnazfaghihitestassignment.serviceImpl;

import com.example.elnazfaghihitestassignment.dto.BorrowedDTO;
import com.example.elnazfaghihitestassignment.helper.BorrowedCSVHelper;
import com.example.elnazfaghihitestassignment.model.Book;
import com.example.elnazfaghihitestassignment.model.Borrowed;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.repository.BorrowedRepository;
import com.example.elnazfaghihitestassignment.service.BookService;
import com.example.elnazfaghihitestassignment.service.BorrowedService;
import com.example.elnazfaghihitestassignment.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowedServiceImpl implements BorrowedService {

    private final BorrowedCSVHelper borrowedCSVHelper;
    private final BorrowedRepository borrowedRepository;
    private final UserService userService;
    private final BookService bookService;

    public BorrowedServiceImpl(BorrowedCSVHelper borrowedCSVHelper, BorrowedRepository borrowedRepository, UserService userService, BookService bookService) {
        this.borrowedCSVHelper = borrowedCSVHelper;
        this.borrowedRepository = borrowedRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    @Transactional
    @Override
    public void addToDB(MultipartFile csvFile) {
        List<BorrowedDTO> borrowedDTOS = borrowedCSVHelper.readFile(csvFile);
        List<Borrowed> borroweds = borrowedDTOS.stream().map(this::borrowedDtoToModel).collect(Collectors.toList());
        borrowedRepository.saveAll(borroweds);
    }

    private Borrowed borrowedDtoToModel(BorrowedDTO borrowedDTO) {
        User user = findBorrowedUser(borrowedDTO.getBorrower());
        Book book = findBorrowedBook(borrowedDTO.getBook());
        return borrowedDTO.toModel(user, book, borrowedDTO.getBorrowedFrom(), borrowedDTO.getBorrowedTo());

    }

    private User findBorrowedUser(String borrowerDTO) {
        String[] borrower = borrowerDTO.split(",");
        return userService.findUserByNameAndFirstName(borrower[0], borrower[1]);
    }

    private Book findBorrowedBook(String title) {
        return bookService.findBookByTitle(title);
    }
}
