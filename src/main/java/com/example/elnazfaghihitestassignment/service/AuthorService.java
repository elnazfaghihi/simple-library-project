package com.example.elnazfaghihitestassignment.service;

import com.example.elnazfaghihitestassignment.model.Author;

import javax.transaction.Transactional;

public interface AuthorService {
    @Transactional
    Author save(Author author);
}
