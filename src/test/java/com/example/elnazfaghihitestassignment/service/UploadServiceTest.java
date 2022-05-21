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

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UploadServiceTest {

    @Autowired
    UploadService uploadService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Test
    public void parseCSVFile_thenOK() throws IOException {
        File testFile = new File("books.csv");
        InputStream stream = new FileInputStream(testFile);
        MultipartFile bookMultipartFile = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);

        File userFile = new File("user.csv");
        InputStream userStream = new FileInputStream(userFile);
        MultipartFile userMultipartFile = new MockMultipartFile("file", userFile.getName(), MediaType.TEXT_HTML_VALUE, userStream);


        File borrowedFile = new File("borrowed.csv");

        InputStream borrowedStream = new FileInputStream(borrowedFile);
        MultipartFile borrowedMultipartFile = new MockMultipartFile("file", borrowedFile.getName(), MediaType.TEXT_HTML_VALUE, borrowedStream);

        uploadService.readFile(userMultipartFile, bookMultipartFile, borrowedMultipartFile);
        assertThat(userService.findUserByName("Aexi").getFirstName(), equalTo("Liam"));
        assertThat(bookService.findBookByTitle("Age of Discontuinity, The").getGenre(), equalTo(Genre.ECONOMICS));

    }
}
