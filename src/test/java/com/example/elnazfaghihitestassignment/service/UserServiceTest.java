package com.example.elnazfaghihitestassignment.service;

import com.example.elnazfaghihitestassignment.enums.Gender;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
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
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void saveUser_ThenOK() throws IOException {
        File testFile = new File("user.csv");

        InputStream stream = new FileInputStream(testFile);
        MultipartFile multipartFileToSend = new MockMultipartFile("file", testFile.getName(), MediaType.TEXT_HTML_VALUE, stream);
        userService.addToDB(multipartFileToSend);

        assertThat(userService.findUserByName("Aexi").getFirstName(), equalTo("Liam"));

    }

    @Test
    public void findUserByInvalidName_ThenThrowException() {
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> userService.findUserByName(anyString()));
        assertThat(exception.getClass(), equalTo(IllegalStateException.class));
        assertThat(exception.getMessage(), equalTo("User not found."));
    }

    @Test
    public void findUserByName_ThenOK() {
        User savedUser = userRepository.save(new User("Aexi", "Liam", Gender.MALE));
        assertThat(userService.findUserByName("Aexi").getFirstName(), equalTo(savedUser.getFirstName()));

    }
}
