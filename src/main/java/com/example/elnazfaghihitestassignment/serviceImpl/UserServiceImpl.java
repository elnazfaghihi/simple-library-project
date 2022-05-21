package com.example.elnazfaghihitestassignment.serviceImpl;

import com.example.elnazfaghihitestassignment.dto.UserDTO;
import com.example.elnazfaghihitestassignment.helper.UserCSVHelper;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.repository.UserRepository;
import com.example.elnazfaghihitestassignment.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserCSVHelper userCSVHelper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserCSVHelper userCSVHelper, UserRepository userRepository) {
        this.userCSVHelper = userCSVHelper;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void addToDB(MultipartFile csvFile) {
        List<UserDTO> userDTO = userCSVHelper.readFile(csvFile);
        List<User> users = userDTO.stream().map(UserDTO::toModel).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name).orElseThrow(() -> new IllegalStateException("User not found."));
    }

    @Override
    public User findUserByNameAndFirstName(String name, String firstName) {
        return userRepository.findUserByNameAndFirstName(name, firstName).orElseThrow(() -> new IllegalStateException("User not found."));
    }

    @Override
    public List<User> getUserListsWithAtLeastOneBorrowedBook() {
        return userRepository.getUserListsWithAtLeastOneBorrowedBook();
    }

    @Override
    public List<User> getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing() {
        return userRepository.getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing();
    }

    @Override
    public List<User> getUsersByBorrowingOneBook(Date date) {
        return userRepository.getUsersByBorrowingOneBook(date);
    }
}
