package com.example.elnazfaghihitestassignment.helper;

import com.example.elnazfaghihitestassignment.dto.UserDTO;
import com.example.elnazfaghihitestassignment.enums.UserCSVHeaderEnum;
import com.example.elnazfaghihitestassignment.helper.CSVHelper;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import javax.transaction.SystemException;
import java.util.Arrays;
import java.util.List;

@Component
public class UserCSVHelper implements CSVHelper<UserDTO> {

    @Override
    public UserDTO createDTOInstance(CSVRecord csvRecord) {
        UserDTO userDTO = new UserDTO();
        Arrays.stream(UserCSVHeaderEnum.values()).forEach(userCSVHeaderEnum -> {
            try {
                userCSVHeaderEnum.setDTOValue(userDTO, csvRecord);
            } catch (SystemException e) {
                e.printStackTrace();
            }
        });
        return userDTO;
    }

    @Override
    public String[] getHeaders() {
        return UserCSVHeaderEnum.getValues().toArray(new String[0]);
    }
}