package com.example.elnazfaghihitestassignment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date convertStringToDate(String stringDate){
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = (!stringDate.equals("")) ? sdf.parse(stringDate) : null;
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }
}
