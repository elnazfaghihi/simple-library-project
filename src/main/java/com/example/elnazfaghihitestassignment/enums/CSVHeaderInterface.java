package com.example.elnazfaghihitestassignment.enums;

import org.apache.commons.csv.CSVRecord;

import javax.transaction.SystemException;
import java.util.function.BiConsumer;

public interface CSVHeaderInterface<T> {

    String getValue();

    default void setDTOValue(T object, CSVRecord csvRecord) throws SystemException {
        try {
            if (this.getDtoSetterFunction() != null) {
                this.getDtoSetterFunction().accept(object, csvRecord.get(this.getValue()));

            }
        } catch (Throwable e) {
            throw new SystemException("Invalid Header type");
        }
    }

    BiConsumer<T, String> getDtoSetterFunction();
}
