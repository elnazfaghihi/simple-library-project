package com.example.elnazfaghihitestassignment.service;

import com.example.elnazfaghihitestassignment.enums.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookServiceTest {


    @Autowired
    BookService bookService;

    @Test
    public void testAddBook() throws IOException {
        File testFile = new File("books.csv");

        InputStream stream =  new FileInputStream(testFile);
        MultipartFile multipartFileToSend = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);
        bookService.addToDB(multipartFileToSend);

        assertThat(bookService.findBookByTitle("Age of Discontuinity, The").getGenre(), equalTo(Genre.ECONOMICS));
    }
}
