package com.example.elnazfaghihitestassignment.controller;

import com.example.elnazfaghihitestassignment.controller.routes.Routes;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Routes.USER_CONTROLLER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list/expired-membership")
    public ResponseEntity<List<User>> getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing());
    }

    @GetMapping("/list/at-least-one-book")
    public ResponseEntity<List<User>> getUserListsWithAtLeastOneBorrowedBook() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserListsWithAtLeastOneBorrowedBook());
    }

    @GetMapping("/list/borrowed-date")
    public ResponseEntity<List<User>> getUsersByBorrowingOneBook(@RequestParam(value = "date") Date date) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByBorrowingOneBook(date));
    }
}
