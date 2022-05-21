package com.example.elnazfaghihitestassignment.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "borrowed")
@Entity
public class Borrowed {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "borrowed_from")
    private Date borrowedFrom;

    @Column(name = "borrowed_to")
    private Date borrowedTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(Date borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }

    public Date getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(Date borrowedTo) {
        this.borrowedTo = borrowedTo;
    }
}
