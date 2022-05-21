package com.example.elnazfaghihitestassignment.enums;

import com.example.elnazfaghihitestassignment.dto.BookDTO;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BookCSVHeaderEnum implements CSVHeaderInterface<BookDTO> {
    TITLE("Title", BookDTO::setTitle),
    AUTHOR("Author", BookDTO::setAuthors),
    GENRE("Genre", BookDTO::setGenre),
    PUBLISHER("Publisher", BookDTO::setPublisher);

    private final String value;
    private final BiConsumer<BookDTO, String> dtoSetterFunction;

    BookCSVHeaderEnum(String value, BiConsumer<BookDTO, String> dtoSetterFunction) {
        this.value = value;
        this.dtoSetterFunction = dtoSetterFunction;
    }

    private static final Map<String, BookCSVHeaderEnum> lookup = Arrays.stream(BookCSVHeaderEnum.values())
            .collect(Collectors.toMap(BookCSVHeaderEnum::getValue, sub -> sub));


    public static BookCSVHeaderEnum getByValue(String value) {
        return lookup.get(value);
    }

    public static List<String> getValues() {

        return Stream.of(values())
                .map(BookCSVHeaderEnum::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public BiConsumer<BookDTO, String> getDtoSetterFunction() {
        return dtoSetterFunction;
    }
}
