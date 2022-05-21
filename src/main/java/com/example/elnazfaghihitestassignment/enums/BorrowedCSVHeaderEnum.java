package com.example.elnazfaghihitestassignment.enums;

import com.example.elnazfaghihitestassignment.dto.BorrowedDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BorrowedCSVHeaderEnum implements CSVHeaderInterface<BorrowedDTO> {
    BORROWER("Borrower", BorrowedDTO::setBorrower),
    BOOK("Book", BorrowedDTO::setBook),
    BORROW_FROM("borrowed from", BorrowedDTO::setBorrowedFrom),
    BORROW_TO("borrowed to", BorrowedDTO::setBorrowedTo);

    private final String value;
    private final BiConsumer<BorrowedDTO, String> dtoSetterFunction;

    BorrowedCSVHeaderEnum(String value, BiConsumer<BorrowedDTO, String> dtoSetterFunction) {
        this.value = value;
        this.dtoSetterFunction = dtoSetterFunction;
    }

    private static final Map<String, BorrowedCSVHeaderEnum> lookup = Arrays.stream(BorrowedCSVHeaderEnum.values())
            .collect(Collectors.toMap(BorrowedCSVHeaderEnum::getValue, sub -> sub));


    public static BorrowedCSVHeaderEnum getByValue(String value) {
        return lookup.get(value);
    }

    public static List<String> getValues() {
        return Stream.of(values())
                .map(BorrowedCSVHeaderEnum::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public BiConsumer<BorrowedDTO, String> getDtoSetterFunction() {
        return dtoSetterFunction;
    }
}
