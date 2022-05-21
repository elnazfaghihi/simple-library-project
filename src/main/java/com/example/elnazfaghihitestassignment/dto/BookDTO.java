package com.example.elnazfaghihitestassignment.dto;

import com.example.elnazfaghihitestassignment.enums.Genre;
import com.example.elnazfaghihitestassignment.model.Author;
import com.example.elnazfaghihitestassignment.model.Book;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDTO {

    private String title;
    private Genre genre;
    private String publisher;
    private Set<Author> authors;

    public Book toModel() {
        return new ModelMapper().map(this, Book.class);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = Genre.getByValue(genre);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = Arrays.stream(authors.split(", ")).map(Author::new).collect(Collectors.toSet());
    }
}
