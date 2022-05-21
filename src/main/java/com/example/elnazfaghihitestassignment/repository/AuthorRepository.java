package com.example.elnazfaghihitestassignment.repository;

import com.example.elnazfaghihitestassignment.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
