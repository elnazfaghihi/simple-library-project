package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.BookDTO;
import com.example.elnazfaghihitestassignment.enums.BookCSVHeaderEnum;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.Arrays;

@Component
public class BookCSVHelper implements CSVHelper<BookDTO> {

    @Override
    public BookDTO createDTOInstance(CSVRecord csvRecord) {
        BookDTO bookDTO = new BookDTO();
        Arrays.stream(BookCSVHeaderEnum.values()).forEach(bookCSVHeaderEnum -> {
            try {
                bookCSVHeaderEnum.setDTOValue(bookDTO, csvRecord);
            } catch (SystemException e) {
                e.printStackTrace();
            }
        });
        return bookDTO;
    }

    @Override
    public String[] getHeaders() {
        return BookCSVHeaderEnum.getValues().toArray(new String[0]);
    }
}
