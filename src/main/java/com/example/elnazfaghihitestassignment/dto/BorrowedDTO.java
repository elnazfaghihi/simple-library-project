package com.example.elnazfaghihitestassignment.dto;

import com.example.elnazfaghihitestassignment.model.Book;
import com.example.elnazfaghihitestassignment.model.Borrowed;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.util.DateUtil;

import java.util.Date;

public class BorrowedDTO {

    private String borrower;
    private String book;
    private Date borrowedFrom;
    private Date borrowedTo;

    public Borrowed toModel(User user, Book book, Date borrowedFrom, Date borrowedTo) {
        Borrowed borrowed = new Borrowed();
        borrowed.setBorrowedTo(borrowedTo);
        borrowed.setBorrowedFrom(borrowedFrom);
        borrowed.setBookId(book.getId());
        borrowed.setUserId(user.getId());
        return borrowed;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(String borrowedFrom) {
        this.borrowedFrom = DateUtil.convertStringToDate(borrowedFrom);
    }

    public Date getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(String borrowedTo) {
        this.borrowedTo = DateUtil.convertStringToDate(borrowedTo);
    }
}
