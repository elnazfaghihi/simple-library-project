package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.BorrowedDTO;
import com.example.elnazfaghihitestassignment.enums.BookCSVHeaderEnum;
import com.example.elnazfaghihitestassignment.enums.BorrowedCSVHeaderEnum;
import com.example.elnazfaghihitestassignment.enums.UserCSVHeaderEnum;
import com.example.elnazfaghihitestassignment.helper.CSVHelper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.Arrays;

@Component
public class BorrowedCSVHelper implements CSVHelper<BorrowedDTO> {

    @Override
    public BorrowedDTO createDTOInstance(CSVRecord csvRecord) {
        BorrowedDTO borrowedDTO = new BorrowedDTO();
        Arrays.stream(BorrowedCSVHeaderEnum.values()).forEach(borrowedCSVHeaderEnum -> {
            try {
                borrowedCSVHeaderEnum.setDTOValue(borrowedDTO, csvRecord);
            } catch (SystemException e) {
                e.printStackTrace();
            }
        });
        return borrowedDTO;
    }

    @Override
    public String[] getHeaders() {
        return BorrowedCSVHeaderEnum.getValues().toArray(new String[0]);
    }
}
