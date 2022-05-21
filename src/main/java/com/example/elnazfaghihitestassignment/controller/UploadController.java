package com.example.elnazfaghihitestassignment.controller;

import com.example.elnazfaghihitestassignment.controller.routes.Routes;
import com.example.elnazfaghihitestassignment.service.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(Routes.CSV_UPLOAD_CONTROLLER)
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload-csv-file")
    public ResponseEntity<String> uploadFile(@RequestParam("books") MultipartFile booksCSVFile, @RequestParam("user") MultipartFile userCSVFile, @RequestParam("borrowed") MultipartFile borrowedCSVFile) {
        uploadService.readFile(userCSVFile, booksCSVFile, borrowedCSVFile);
        return null;
    }
}
