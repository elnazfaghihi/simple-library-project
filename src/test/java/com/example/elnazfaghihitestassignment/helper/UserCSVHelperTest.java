package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.UserDTO;
import com.example.elnazfaghihitestassignment.enums.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserCSVHelperTest {

    @Autowired
    UserCSVHelper userCSVHelper;

    @Test
    public void testReadingPersonObjectsFromCsvData() throws Exception {
        File testFile = new File("user.csv");

        InputStream stream =  new FileInputStream(testFile);
        MultipartFile  multipartFileToSend = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);
        List<UserDTO> userDTO = userCSVHelper.readFile(multipartFileToSend);
        assertThat(11, equalTo(userDTO.size()));
        UserDTO userDTO1 = userDTO.get(0);
        assertThat("Aexi", equalTo(userDTO1.getName()));
        assertThat("Liam", equalTo(userDTO1.getFirstname()));
        assertThat(Gender.MALE, equalTo(userDTO1.getGender()));

        UserDTO userDTO2 = userDTO.get(1);
        assertThat("Zhungwang", equalTo(userDTO2.getName()));
        assertThat("Noah", equalTo(userDTO2.getFirstname()));
        assertThat(Gender.MALE, equalTo(userDTO2.getGender()));
    }
}
