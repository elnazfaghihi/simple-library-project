package com.example.elnazfaghihitestassignment.repository;

import com.example.elnazfaghihitestassignment.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
}
