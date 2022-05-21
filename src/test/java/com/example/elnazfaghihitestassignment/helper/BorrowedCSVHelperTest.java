package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.BorrowedDTO;
import com.example.elnazfaghihitestassignment.helper.BorrowedCSVHelper;
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
public class BorrowedCSVHelperTest {

    @Autowired
    BorrowedCSVHelper borrowedCSVHelper;

    @Test
    public void testReadingPersonObjectsFromCsvData() throws Exception {
        File testFile = new File("borrowed.csv");

        InputStream stream =  new FileInputStream(testFile);
        MultipartFile  multipartFileToSend = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);
        List<BorrowedDTO> borrowedDTOS = borrowedCSVHelper.readFile(multipartFileToSend);
        assertThat(118, equalTo(borrowedDTOS.size()));
    }
}
