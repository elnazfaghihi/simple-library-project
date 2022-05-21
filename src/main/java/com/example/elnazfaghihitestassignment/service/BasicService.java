package com.example.elnazfaghihitestassignment.service;

import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

public interface BasicService {

    @Transactional
    void addToDB(MultipartFile csvFile);
}
