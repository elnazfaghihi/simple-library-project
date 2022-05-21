package com.example.elnazfaghihitestassignment.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void readFile(MultipartFile userCSVFile, MultipartFile bookCSVFile, MultipartFile borrowedCSVFile);
}
