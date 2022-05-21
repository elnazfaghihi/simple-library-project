package com.example.elnazfaghihitestassignment.repository;

import com.example.elnazfaghihitestassignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);

    @Query("select distinct b from Book b left join Borrowed br on b.id=br.bookId where br.bookId is null")
    List<Book> getAvailableBooks();

    @Query("select b from Book b join Borrowed br on b.id=br.bookId where br.userId= :userId and br.borrowedFrom between :from and :to")
    List<Book> getUserBorrowedBooksAtSpecificDateRange(Long userId, Date from, Date to);
}
