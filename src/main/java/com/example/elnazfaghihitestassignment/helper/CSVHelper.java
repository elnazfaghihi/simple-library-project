package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.enums.UserCSVHeaderEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public interface CSVHelper<T> {
    default List<T> readFile(MultipartFile csvFile) {

        CSVFormat.Builder builder = CSVFormat.Builder.create();
        builder.setHeader(getHeaders()).setSkipHeaderRecord(true);
        CSVFormat csvFormat = builder.build();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, csvFormat)) {
            List<T> dtos = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                dtos.add(this.createDTOInstance(csvRecord));
            }
            return dtos;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    T createDTOInstance(CSVRecord csvRecord);

    String[] getHeaders() ;
}
