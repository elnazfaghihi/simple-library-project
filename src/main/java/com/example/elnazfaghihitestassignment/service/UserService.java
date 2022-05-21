package com.example.elnazfaghihitestassignment.service;

import com.example.elnazfaghihitestassignment.model.User;

import java.util.Date;
import java.util.List;


public interface UserService extends BasicService{
    User findUserByName(String name);
    User findUserByNameAndFirstName(String name,String firstName);
    List<User> getUserListsWithAtLeastOneBorrowedBook();
    List<User> getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing();
    List<User> getUsersByBorrowingOneBook(Date date);
}
