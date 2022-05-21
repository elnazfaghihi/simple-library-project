package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.BookDTO;
import com.example.elnazfaghihitestassignment.enums.Genre;
import com.example.elnazfaghihitestassignment.helper.BookCSVHelper;
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
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookCSVHelperTest {

    @Autowired
    BookCSVHelper bookCSVHelper;

    @Test
    public void testReadingPersonObjectsFromCsvData() throws Exception {
        File testFile = new File("books.csv");

        InputStream stream = new FileInputStream(testFile);
        MultipartFile multipartFileToSend = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);
        List<BookDTO> bookDTOS = bookCSVHelper.readFile(multipartFileToSend);
        assertThat(186, equalTo(bookDTOS.size()));
        BookDTO bookDTO1 = bookDTOS.get(0);
        assertThat("Age of Discontuinity, The", equalTo(bookDTO1.getTitle()));
        assertThat("Random House", equalTo(bookDTO1.getPublisher()));
        assertThat(Genre.ECONOMICS, equalTo(bookDTO1.getGenre()));
        assertThat(2, equalTo(bookDTO1.getAuthors().size()));
    }
}
