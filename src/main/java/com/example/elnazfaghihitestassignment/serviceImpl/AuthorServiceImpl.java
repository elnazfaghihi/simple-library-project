package com.example.elnazfaghihitestassignment.serviceImpl;

import com.example.elnazfaghihitestassignment.model.Author;
import com.example.elnazfaghihitestassignment.repository.AuthorRepository;
import com.example.elnazfaghihitestassignment.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
